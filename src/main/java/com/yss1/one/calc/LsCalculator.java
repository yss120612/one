package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.LgotaDescrDao;
import com.yss1.one.models.LgotaDescription;
import com.yss1.one.models.LgotaUnion;
import com.yss1.one.models.Staj;
import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

@Service
public class LsCalculator {
@Autowired
LgotaDescrDao lDao;
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


private boolean inList(LgotaDescription ld, String patt) {
	
	if (ld.getName().equals(patt)) return true;
	if (ld.getForSumm()==null) return false;
	for (LgotaUnion lu: ld.getForSumm()) {
		if(lu.getCode().equals(patt)) {
			ld.setSummUsed(true);
			return true;
		}
	}
	return false;
}



public Period calcLS2(List<Staj> stlist, String ls, boolean isMan) {
	LgotaDescription lg=lDao.getLgota(ls);
	Period myPeriod=calcAbsLS(stlist, ls);
	
	Period padd;
	if (lg.getForSumm()!=null) {
	for (LgotaUnion lu : lg.getForSumm()){
		padd=null;
		if (lu.getUsl_man()>0.1f)
		{
		if (isMan) {
			if (myPeriod.isMore(lu.getUsl_man())) padd=calcAbsLS(stlist, lu.getCode()); 
		}
		else {
			if (myPeriod.isMore(lu.getUsl_woman())) padd=calcAbsLS(stlist, lu.getCode());
		}
		}
		else
		{
			padd=calcAbsLS(stlist, lu.getCode());
		}
		
		if (padd!=null) {
			System.out.println("mult="+lu.getKoeff()+" main="+lg.getName()+" added="+lu.getCode()+" period="+padd.toString());
			if (lu.getKoeff()<0.99f || lu.getKoeff()>1.01f) {
				padd=padd.multPeriod(lu.getKoeff());
			}
			myPeriod.addPeriod(padd);
		}
		
	}
	}
	return myPeriod;
}


//записываем нкжные куски стажа в отдельный массив
public Period calcLS(List<Staj> stlist, String ls) {
	LgotaDescription lg=lDao.getLgota(ls);
	lg.setSummUsed(false);
	List<Staj> tmp = new ArrayList<>();
	Staj current=null;
	for (Staj st:stlist) {
		if (lg.getField().equals("cwcext") && inList(lg,st.getCwcext())) {
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
		}else if(lg.getField().equals("cspext") && inList(lg,st.getCspext())) {
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
		}else if(lg.getField().equals("cggext") && inList(lg,st.getCggext())) {
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


//записываем нкжные куски стажа в отдельный массив
public Period calcAbsLS(List<Staj> stlist, String ls) {
	List<Staj> tmp = new ArrayList<>();
	Staj current=null;
	for (Staj st:stlist) {
		if (st.getCwcext().equals(ls)||st.getCspext().equals(ls)||st.getCggext().equals(ls)) {
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
	LgotaDescription lg=lDao.getLgota(ls);
	//System.out.println("period="+period.toString());
	boolean os=false;
	
	//проверим общий стаж
	if (isMan) {
		os=lg.getMan_os()<0.1f||year>=lg.getMan_os();
	}else{
		os=lg.getWoman_os()<0.1f||year>=lg.getWoman_os();
	}
	if (!os) return res;
	//System.out.println("OS="+year+" nado="+lg.getWoman_os());
	
	//проверим спец стаж
	if (isMan) {
		os=period.getYears()>=lg.getMan_ss();
	}else {
		os=period.getYears()>=lg.getWoman_ss();
	}
	
	
	Period p1,p2;
	//если (полная выработка) все норм возвращаем
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
			if (lg.getWoman_pens()>0)
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
	if (isMan)
	{
	//res= (int)(Math.floor((period.getYears()*12f+period.getMonths())/lg.getMan_d())*lg.getMan_ds());
		res= (int)((period.getYears()*12f+period.getMonths())/lg.getMan_d()*lg.getMan_ds());
	}
	else
	{
		res= (int)((period.getYears()*12f+period.getMonths())/lg.getWoman_d()*lg.getWoman_ds());
		//res= (int)(Math.floor((period.getYears()*12f+period.getMonths())/lg.getWoman_d())*lg.getWoman_ds());
	}

	return res;
}


public boolean isNorthPlus(String name) {
	LgotaDescription lg=lDao.getLgota(name);
	if (lg!=null && lg.isNorthPlus()) return true;
	return false;
}


public Period getForNorth(List<Staj> rawStaj, String name) {
	
	List<Staj> tmp = new ArrayList<>();
	Staj current=null;
	//закидываем периоды с нужным стажем
	for (Staj st:rawStaj) {
		if (st.getCwcext().equals(name)||st.getCspext().equals(name)||st.getCggext().equals(name)) {
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
	//вычитаем север
	for (Staj stg: tmp) {
		for (Staj st:rawStaj) {
			if (st.getCggext().equals("РКС")||st.getCggext().equals("МКС")) {
				if (Utils.between(stg.getStartDate(), st.getStartDate(), st.getEndDate())) {
					stg.setStartDate(st.getEndDate());
				}
				if (Utils.between(stg.getEndDate(), st.getStartDate(), st.getEndDate())) {
					stg.setEndDate(st.getStartDate());
				}
			}
		}
	}
	tmp.removeIf(x->!x.getEndDate().after(x.getStartDate()));
	return stCalc.getStajAll(tmp);
}




}
