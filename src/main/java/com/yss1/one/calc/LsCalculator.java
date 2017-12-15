package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.List;

import org.postgresql.jdbc2.ArrayAssistantRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.LgotaDao;
import com.yss1.one.models.Lgota;
import com.yss1.one.models.Staj;
import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

@Service
public class LsCalculator {
@Autowired
LgotaDao lDao;
@Autowired
StajCalculator stCalc;

public Period calcS(List<Staj> stlist) {
	List<Staj> tmp = new ArrayList<>();
	Staj current=null;
	for (Staj st:stlist) {
		if (stCalc.skipThis(st)) continue;
		if (current==null) {
			current=Staj.makeCopy(st);
		}
		else if (current.getEndDate().before(st.getStartDate()))
		{
			tmp.add(current);
			current=Staj.makeCopy(st);
		}
		else {
			if (st.getEndDate().after(current.getEndDate())) current.setEndDate(st.getEndDate());
		}
	}
	if (current!=null && !tmp.contains(current)) tmp.add(current);
	return stCalc.getStajAll(tmp);
}


public Period calcNS(List<Staj> stlist) {
	List<Staj> tmp = new ArrayList<>();
	Staj current=null;
	for (Staj st:stlist) {
		if (st.getVidDeyat().contains("РАБОТА")) continue;
		if (current==null) {
			current=Staj.makeCopy(st);
		}
		else if (current.getEndDate().before(st.getStartDate()))
		{
			tmp.add(current);
			current=Staj.makeCopy(st);
		}
		else {
			if (st.getEndDate().after(current.getEndDate())) current.setEndDate(st.getEndDate());
		}
	}
	if (current!=null && !tmp.contains(current)) tmp.add(current);
	return stCalc.getStajAll(tmp);
}


public Period calcLS(List<Staj> stlist, String ls) {
	Lgota lg=lDao.getLgota(ls);
	
	List<Staj> tmp = new ArrayList<>();
	Staj current=null;
	for (Staj st:stlist) {
		if (lg.getField().equals("cwcext") && st.getCwcext().equals(lg.getName())) {
			if (current==null) {
				current=Staj.makeCopy(st);
			}
			else if (current.getEndDate().before(st.getStartDate()))
			{
				tmp.add(current);
				current=Staj.makeCopy(st);
			}
			else {
				if (st.getEndDate().after(current.getEndDate())) current.setEndDate(st.getEndDate());
			}
		}else if(lg.getField().equals("cspext") && st.getCspext().equals(lg.getName())) {
			if (current==null) {
				current=Staj.makeCopy(st);
			}
			else if (current.getEndDate().before(st.getStartDate()))
			{
				tmp.add(current);
				current=Staj.makeCopy(st);
			}
			else {
				if (st.getEndDate().after(current.getEndDate())) current.setEndDate(st.getEndDate());
			}
		}else if(lg.getField().equals("cggext") && st.getCggext().contains(lg.getName())) {
			if (current==null) {
				current=Staj.makeCopy(st);
			}
			else if (current.getEndDate().before(st.getStartDate()))
			{
				tmp.add(current);
				current=Staj.makeCopy(st);
			}
			else {
				if (st.getEndDate().after(current.getEndDate())) current.setEndDate(st.getEndDate());
			}
		}
	}
	if (current!=null && !tmp.contains(current)) tmp.add(current);
	return stCalc.getStajAll(tmp);
}


public int calcLgotMonth(Period period, String ls, int year, boolean isMan) {
	int res=0;
	Lgota lg=lDao.getLgota(ls);
	
	boolean os=false;
	
	//проверим общий стаж
	if (isMan) {
		os=lg.getMan_os()<0.1f||year>=lg.getMan_os();
	}else{
		os=lg.getWoman_os()<0.1f||year>=lg.getWoman_os();
	}
	if (!os) return res;
	
	
	//проверим спец стаж
	if (isMan) {
		os=period.getYears()>=lg.getMan_ss();
	}else {
		os=period.getYears()>=lg.getWoman_ss();
	}
	
	Period p1,p2;
	//если все норм возвращаем
	if (os) {
		if (isMan) {
			if (lg.getMan_pens()>0)
			{
				return (int)(60-lg.getMan_pens())*12;
			}
			else
			{
				p1=new Period((int)lg.getMan_ss(), 0, 0);
				p2=new Period(period);
				p2.diffPeriod(p1);
				return p2.getMonths()+p2.getYears()*12;
			}
		}
		else {
			if (lg.getMan_pens()>0)
			{
				return (int)(55-lg.getWoman_pens())*12;
			}
			else
			{
				p1=new Period((int)lg.getWoman_ss(), 0, 0);
				p2=new Period(period);
				p2.diffPeriod(p1);
				return p2.getMonths()+p2.getYears()*12;
			}
		}
	}
		
	float minSS=0;
	//применение части спецстажа
	if (lg.getHalf()>0.1f) {
		if (isMan) {
			minSS=lg.getMan_ss()/lg.getHalf();
		}else {
			minSS=lg.getWoman_ss()/lg.getHalf();
		}
	}
	else {
		return 0;
	}
	
	//если не достаточно выходим
	if (period.getYears()<minSS)
	{
		return 0;
	}
	
	
	if (ls.equals("27-1") || ls.equals("27-2")|| ls.equals("ЗП12Б")|| ls.equals("ЗП12А"))
	{
		if (isMan) {
			res=(int)((period.getYears()+period.getMonths()/12f)*lg.getMan_ds()/lg.getMan_d())*12;
		}else {
			res=(int)((period.getYears()+period.getMonths()/12f)*lg.getWoman_ds()/lg.getWoman_d())*12;
		}
	
	}
	else {
		if (isMan) {
			res=(int)((period.getYears()+period.getMonths()/12f)*lg.getMan_ds()/lg.getMan_d()*12);
		}else {
			res=(int)((period.getYears()+period.getMonths()/12f)*lg.getWoman_ds()/lg.getWoman_d()*12);
		}	
	}
	return res;
}




}
