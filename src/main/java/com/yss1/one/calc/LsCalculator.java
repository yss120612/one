package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Date;
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
	Period myPeriod=calcAbsLPeriod(stlist, ls);
	
	Period padd;
	if (lg.getForSumm()!=null) {
	for (LgotaUnion lu : lg.getForSumm()){
		padd=null;
		if (lu.getUsl_man()>0.1f)
		{
		if (isMan) {
			if (myPeriod.isMore(lu.getUsl_man())) padd=calcAbsLPeriod(stlist, lu.getCode()); 
		}
		else {
			if (myPeriod.isMore(lu.getUsl_woman())) padd=calcAbsLPeriod(stlist, lu.getCode());
		}
		}
		else
		{
			padd=calcAbsLPeriod(stlist, lu.getCode());
		}
		
		if (padd!=null) {
			if (lu.getKoeff()<0.99f || lu.getKoeff()>1.01f) {
				padd=padd.multPeriod(lu.getKoeff());
			}
			myPeriod.addPeriod(padd);
		}
		
	}
	}
	return myPeriod;
}

public List<Staj> calcLS3(List<Staj> stlist, String ls, boolean isMan) {
	LgotaDescription lg=lDao.getLgota(ls);
	List<Staj> myLS=calcAbsLStaj(stlist, ls);
	Period result=stCalc.getStajAll(myLS);
	
	List<Staj> sadd;
	if (lg.getForSumm()!=null) {
	for (LgotaUnion lu : lg.getForSumm()){
		sadd=null;
		if (lu.getUsl_woman()>0.1f)
		{
		if (isMan) {
			if (result.isMore(lu.getUsl_man())) sadd=calcAbsLStaj(stlist, lu.getCode()); 
		}
		else {
			if (result.isMore(lu.getUsl_woman())) sadd=calcAbsLStaj(stlist, lu.getCode());
		}
		}
		else
		{
			sadd=calcAbsLStaj(stlist, lu.getCode());
		}
		
		if (sadd!=null) {
			if (lu.getKoeff()<0.99f || lu.getKoeff()>1.01f) {
				for (Staj st:sadd) st.setMultiplier(lu.getKoeff());
			}
			myLS.addAll(sadd);
		}
		
	}
	}
	return myLS;
}


//записываем нкжные куски стажа в отдельный массив суммируем то, что
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



public Period calcAbsLPeriod(List<Staj> stlist, String ls) {
	return stCalc.getStajAll(calcAbsLStaj(stlist,ls));
}

public List<Staj> calcAbsLStaj(List<Staj> stlist, String ls) {
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
	return tmp;
}



public int calcLgotMonth(Period period, String ls, int year, boolean isMan, Date pravo) {
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
	Date dt=new Date();
	//если (полная выработка) все норм возвращаем
	if (os) {
		if (isMan) {
			if (lg.getMan_pens()>0.01f)
			{
				return (int)(60-lg.getMan_pens())*12;
			}
			else
			{
//				p1=new Period((int)lg.getMan_ss(), 0, 0);
//				p2=new Period(period);
//				p2.diffPeriod(p1);
//				dt=Utils.addDay(dt, -(p2.getYears()*12*30+p2.getMonths()*30+p2.getDays()));
//				p2=Utils.makePeriod(dt, pravo, 0);
//				return p2.getMonths()+p2.getYears()*12;
				return 1000;
			}
		}
		else {
			if (lg.getWoman_pens()>0.01f)
			{
				return (int)(55-lg.getWoman_pens())*12;
			}
			else
			{
//				p1=new Period((int)lg.getWoman_ss(), 0, 0);
//				p2=new Period(period);
//				p2.diffPeriod(p1);
//				dt=Utils.addDay(dt, -(p2.getYears()*12*30+p2.getMonths()*30+p2.getDays()));
//				p2=Utils.makePeriod(dt, pravo, 0);
//				return p2.getMonths()+p2.getYears()*12;
				return 1000;
				
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


public Date getPravo(List<Staj> ls,String lgtstr, boolean isMan) {
	LgotaDescription lg=lDao.getLgota(lgtstr);
	if (ls!=null) return getLgotPravo(ls,new Period((int)(isMan?lg.getMan_ss():lg.getWoman_ss()),0,0));
	else return null;
}

private Date getLgotPravo(List<Staj> ls, Period lper) {	
	Date d;
	Staj current=null;
	Period per=new Period(0,0,0);
	Period per0=per;
	boolean stajOK=false;

	for (Staj s:ls) {
		current=s;
		d=s.getStartDate();
		per.addPeriod(Utils.makePeriod(s.getStartDate(),s.getEndDate(),s.getAddDay()));
		if (per.isMoreEqual(lper)) {
			stajOK=true;
			break;
		}
		
		per0=new Period(per);
	}
	if (!stajOK) return null;
	per=new Period(lper);
	per.diffPeriod(per0);
	
	d=Utils.addDay(current.getStartDate(),per.getDays()+per.getMonths()*30+per.getYears()*360);
	return d;
}

public boolean isNorthPlus(String name) {
	LgotaDescription lg=lDao.getLgota(name);
	if (lg!=null && lg.isNorthPlus()) return true;
	return false;
}


public Period getForNorth(List<Staj> rawStaj, String name) {
	
	List<Staj> tmp = calcAbsLStaj(rawStaj, name); 
			
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
