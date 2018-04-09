package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yss1.one.dao.LgotaDescrDao;
import com.yss1.one.models.LgotaDescription;
import com.yss1.one.models.LgotaUnion;
import com.yss1.one.models.Staj;
import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

//Калькулятор расчета медицинского стажа
@Service
public class MedCalculator {
	
@Autowired
LgotaDescrDao lDao;
	
@Autowired
StajCalculator stCalc;
	

private Date dfrom=Utils.makeDate(1999,11,1);
	
public Period getMedStajAll(List<Staj> ls,String what) {
		Period st1=stCalc.getSpecStajBefore(ls, dfrom,"27-СМХР");
		Period st2=stCalc.getSpecStajAfter(ls, dfrom,"27-СМХР");
		
		Period st3=stCalc.getSpecStajBefore(ls, dfrom,"27-СМ").multPeriod(1.25f);
		Period st4=stCalc.getSpecStajAfter(ls, dfrom,"27-СМ");
		
		Period st5=stCalc.getSpecStajBefore(ls, dfrom,"27-ГДХР").multPeriod(1.5f);
		Period st6=stCalc.getSpecStajAfter(ls, dfrom,"27-ГДХР").multPeriod(1.5f);
		
		Period st7=stCalc.getSpecStajBefore(ls, dfrom,"27-ГД");
		Period st8=stCalc.getSpecStajAfter(ls, dfrom,"27-ГД");
		
		//System.out.println("st1="+st3);
		//System.out.println("st2="+st4);
		
		boolean containsCity=!st5.isEmpty()||!st6.isEmpty()||!st7.isEmpty()||!st8.isEmpty();
		if (what.equals("27-СМ")) {
			if (containsCity) st4=st4.multPeriod(1.25f);
		}
		
		if (what.equals("27-СМХР")) {
			if (containsCity) {
			st1=st1.multPeriod(1.75f);
			st2=st2.multPeriod(1.75f);
			}
			else
			{
				st1=st1.multPeriod(1.5f);
				st2=st2.multPeriod(1.5f);
			}
		}
		
		if (what.equals("27-СМХР")) {
			st1.addPeriod(st2);
			return st1;
		}
		else if (what.equals("27-СМ")){
			st3.addPeriod(st4);
			return st3;
		}
		else if (what.equals("27-ГДХР")){
			st5.addPeriod(st6);
			return st5;
		}
		else {
			st7.addPeriod(st8);
			return st7;
		}
		
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

public Period getMedPeriod(List<Staj> stl,String vid) {
		LgotaDescription lg=lDao.getLgota(vid);
		List<Staj> toa=getMedStaj(stl,lg);
		if (toa!=null) {	
			return getMedStajAll(toa,vid);
		}
		else
		{
			return new Period (0,0,0);
		}
}
	
public Date getPravo(List<Staj> ls, String lgt, boolean isMan) {
	LgotaDescription lg=lDao.getLgota(lgt);
	List<Staj> l=getMedStaj(ls, lg);
	if (l!=null) return getLgotPravo(l,new Period((int)(isMan?lg.getMan_ss():lg.getWoman_ss()),0,0), lgt);
	else return null;
}

private Date getLgotPravo(List<Staj> ls, Period lper, String lgt) {	
	Date d;
	Staj current=null;
	Period per=new Period(0,0,0);
	Period per0=per;
	boolean stajOK=false;
	boolean city = false;
	for (Staj j : ls) {
		if (j.getCspext().contains("27-ГД")) {
			city = true;
			break;
		}
	}
	
	for (Staj j : ls) {
		j.setMultiplier(getMultiplier(ls, j, lgt,city));
	}
	
	for (Staj s:ls) {
		current=s;
		d=s.getStartDate();
		per.addPeriod(Utils.makePeriod(s.getStartDate(),s.getEndDate(),s.getAddDay()).multPeriod(s.getMultiplier()));
		if (per.isMoreEqual(lper)) {
			stajOK=true;
			break;
		}
		per0=new Period(per);
	}
	if (!stajOK) return null;
	
	per=new Period(lper);
	per.diffPeriod(per0);
	int days=per.getDays()+per.getMonths()*30+per.getYears()*360;
	if (current!=null) days=(int)(days/current.getMultiplier());
	d=Utils.addDay(current.getStartDate(),days);
	return d;
}


private List<Staj> getMedStaj(List<Staj> stl,LgotaDescription vid)
{
	
	if (stl==null) return null;
	List<Staj> sttmp=new ArrayList<Staj>();
	float stavka;
	Staj current=null;
	
	//отбираем только с нужным кодом которые или имеют ставку или до 01-11-1999г.
	for (Staj st: stl) {
		
		if (inList(vid,st.getCspext()))
		{
			current=new Staj(st);
			if (st.getStartDate().before(dfrom)) {
				if (st.getEndDate().after(dfrom)) {
					current.setStavka(1f);
					current.setEndDate(Utils.addDay(dfrom,-1));
					current.setAddDay(0);
					sttmp.add(current);
					
					current=new Staj(st);
					current.setStartDate(dfrom);
				}
				else
				{
					current.setStavka(1f);
					sttmp.add(current);
					continue;
				}
			}
			stavka=Utils.getFloat(current.getDopcspext());
			if (stavka>0.01f) {
				current.setStavka(stavka);
				sttmp.add(current);
			}
		}
	
	}
	if (sttmp.isEmpty()) return null;
	Collections.sort(sttmp);
	
	List<Staj> toadd1=new ArrayList<Staj>();
	List<Staj> toadd2=new ArrayList<Staj>();
	List<Staj> toadd3=new ArrayList<Staj>();

	int counter=0;
	boolean changed;

	for (Staj s0:sttmp) {
		s0.setNumb(++counter);
		toadd1.add(s0);
		toadd2.add(s0);
	}

	boolean s1SL,s1FL,s2SL,s2FL;
	while(true)
	{
	changed=false;

	for (Staj s1:toadd1) {
		toadd3.clear();
		for (Staj s2:toadd2) {
			if(s1.getNumb()==s2.getNumb()) continue;
			current=null;
			if (Utils.intersect(s1.getStartDate(),s1.getEndDate(),s2.getStartDate(),s2.getEndDate())) {
				changed=true;
				current=Staj.makeCopy(s1);
				current.setNumb(++counter);
				
				
				if (Utils.beforeOrEqual(s1.getStartDate(),s2.getStartDate()))
				{
					s1SL=true;
					s2SL=false;
				}
				else {
					s2SL=true;
					s1SL=false;
				}
				
				if (Utils.beforeOrEqual(s1.getEndDate(),s2.getEndDate()))
				{
					s2FL=true;
					s1FL=false;
				}
				else {
					s1FL=true;
					s2FL=false;
				}

				
				if (s1SL && s1FL) {
					current.setStartDate(s2.getStartDate());
					current.setEndDate(s2.getEndDate());
					current.setCspext(s1.getCspext()+","+s2.getCspext());
					current.setStavka(s1.getStavka()+s2.getStavka());
										
					s2.setStartDate(Utils.addDay(s2.getEndDate(),1));
					s2.setEndDate(s1.getEndDate());
					s1.setEndDate(Utils.addDay(current.getStartDate(),-1));
										
					s2.setCspext(s1.getCspext());
					s2.setStavka(s1.getStavka());
					s2.setNumb(s1.getNumb());
				}
				else if (s2SL && s1FL) {
					current.setStartDate(s1.getStartDate());
					current.setEndDate(s2.getEndDate());
					current.setCspext(s1.getCspext()+","+s2.getCspext());
					current.setStavka(s1.getStavka()+s2.getStavka());
										
					s1.setStartDate(Utils.addDay(current.getEndDate(),1));
					s2.setEndDate(Utils.addDay(current.getStartDate(),-1));
					s2.setAddDay(0);
				}
				else if (s1SL && s2FL) {
					current.setStartDate(s2.getStartDate());
					current.setEndDate(s1.getEndDate());
					current.setCspext(s1.getCspext()+","+s2.getCspext());
					current.setStavka(s1.getStavka()+s2.getStavka());
										
					s1.setEndDate(Utils.addDay(current.getStartDate(),-1));
					s2.setStartDate(Utils.addDay(current.getEndDate(),1));
				}
				else if (s2SL && s2FL) {
					current.setStartDate(s1.getStartDate());
					current.setEndDate(s1.getEndDate());
					current.setCspext(s1.getCspext()+","+s2.getCspext());
					current.setStavka(s1.getStavka()+s2.getStavka());
										
					s1.setStartDate(Utils.addDay(s1.getEndDate(),1));
					s1.setEndDate(s2.getEndDate());
					s2.setEndDate(Utils.addDay(current.getStartDate(),-1));
										
					s1.setCspext(s2.getCspext());
					s1.setStavka(s2.getStavka());
					s1.setNumb(s2.getNumb());
					s1.setAddDay(0);
					
				}
				
				
				toadd3.add(current);
			}
	
				
			}
		toadd2.addAll(toadd3);
		toadd2.removeIf(x->!x.getStartDate().before(x.getEndDate()));
		}
		toadd1.removeIf(x->!x.getStartDate().before(x.getEndDate()));
	if (!changed) break;
	}

	
	for(Staj s1:toadd2)
	{
		setLgota(s1);
	}
	toadd2.removeIf(x->x.getStavka()<0.01f);	
	Collections.sort(toadd2);
	return toadd2;
}



private float getMultiplier(List<Staj> ls, Staj st, String lgt, boolean city) {
		if (st==null) return 1f; 
		if (lgt.equals("27-ГД"))
			return 1f;
		else if (lgt.equals("27-ГДХР"))
			return 1.5f;

		if (lgt.equals("27-СМ")) {
			if (city) {
				return 1.25f;
			} else {
				if (st.getEndDate().before(dfrom))
					return 1.25f;
				else
					return 1f;
			}
		} else if (lgt.equals("27-СМХР")) {
			if (city) {
				return 1.75f;
			} else {
				return 1.5f;
			}
		}
		return 1f;
	}
	
private void setLgota(Staj s1) {
	// TODO Auto-generated method stub
	Set<String>  csp= new HashSet<String>();
	String [] csarr = s1.getCspext().split(",");
	
	for (int i=0;i<csarr.length;i++) csp.add(csarr[i]);
	String minLgota=getLowLgota(csp);
			
	if (s1.getStartDate().before(dfrom)) {
		if (csp.contains("27-СМХР")) {s1.setCspext("27-СМХР");} else 
		if (csp.contains("27-ГДХР")) {s1.setCspext("27-ГДХР");} else			
		if (csp.contains("27-СМ")) {s1.setCspext("27-СМ");} else
		{s1.setCspext("27-ГД");}
		
	}
	else {

		if (s1.getStavka()<0.99f) {
			if (minLgota.equals("27-СМХР")) {s1.setCspext("27-ГДХР");s1.setStavka(1.0f);}
			else if (minLgota.equals("27-ГДХР")) {s1.setCspext("27-СМ");s1.setStavka(1.0f);}
			else if (minLgota.equals("27-СМ")) {s1.setCspext("27-ГД");s1.setStavka(1.0f);}
			else {s1.setCspext("");s1.setStavka(0.0f);}
		}
		else
		{
			s1.setCspext(minLgota);
		}
		
		
	}
	
}

private String getLowLgota(Set<String> lgotes) {
	if (lgotes.size()<1) return "";
	if(lgotes.contains("27-ГД")) return "27-ГД";
	if(lgotes.contains("27-СМ")) return "27-СМ";
	if(lgotes.contains("27-ГДХР")) return "27-ГДХР";
	return "27-СМХР";
}


}
