package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Collections;
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

//Калькулятор расчета медицинского стажа
@Service
public class MedCalculator {
	@Autowired
	LgotaDescrDao lDao;
	
//	public Period getMedStajBefore(List<Staj> ls, Date bd, boolean containsCity) {
//		// what=1 ГД,what=2 СМ, what=3 ГДХР, what=4 СМХР
//
//		Period per = new Period(0, 0, 0);
//		Date border = Utils.makeDate(1999, 11, 1);
//		for (Staj st : ls) {
//			if (st.getStartDate().after(bd))
//				continue;
//			
//			if ( st.getCspext().contains("СМХР")) {
//				if (containsCity) {
//					if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//						per.addPeriod(Utils.multPeriod(
//								Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.75f));
//					} else {
//						per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.75f));
//					}
//				} else {
//					if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//						per.addPeriod(Utils.multPeriod(
//								Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.5f));
//					} else {
//						per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.5f));
//					}
//				}
//				
//			} else if (st.getCspext().contains("ГДХР")) {
//				if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//					per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()),1.5f));
//				} else {
//					per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.5f));
//				}
//
//			} else if (st.getCspext().contains("СМ")) {
//				if (containsCity) {
//					if (st.getStartDate().before(border)) {
//						if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//							per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.25f));
//							//per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
//						} else {
//							per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.25f));
//							//per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
//						}
//					} else {
//						if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//							per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
//						} else {
//							per.addPeriod(Utils.makePeriod(st.getStartDate(), bd, 0));
//						}
//					}
//				} else {
//					if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//						per.addPeriod(Utils.multPeriod(
//								Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.25f));
//					} else {
//						per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.25f));
//					}
//				}
//				
//			} else if (st.getCspext().contains("ГД")) {
//				if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
//					per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
//				} else {
//					per.addPeriod(Utils.makePeriod(st.getStartDate(), bd, 0));
//				}
//			}
//
//		}
//		return per;
//	}

	public Period getMedStajBefore(List<Staj> ls, Date bd, String ms) {
		Period per = new Period(0, 0, 0);
		for (Staj st : ls) {
			if (st.getStartDate().after(bd) ||  !st.getCspext().contains(ms))
				continue;
			
			
					if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
						per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
					} else {
						per.addPeriod(Utils.makePeriod(st.getStartDate(), bd, 0));
					}
			
		}
		return per;
	}
	
	
	public Period getMedStajAfter(List<Staj> ls, Date bd, String ms) {
		Period per = new Period(0, 0, 0);
		for (Staj st : ls) {
			if (st.getEndDate().before(bd) || !st.getCspext().contains(ms))
				continue;
			
					if (Utils.afterOrEqual(st.getStartDate(), bd)) {
						per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
					} else {
						per.addPeriod(Utils.makePeriod(bd,st.getEndDate(), 0));
					}
					}
		return per;
	}
	
	
	public Period getMedStajAll(List<Staj> ls,String what) {
		
		//"СМХР""ГДХР""ГД""СМ"
		
		Period st1=getMedStajBefore(ls, Utils.makeDate(1999, 11, 1),"СМХР").multPeriod(1.25f);
		Period st2=getMedStajAfter(ls, Utils.makeDate(1999, 11, 1),"СМХР");
		
		Period st3=getMedStajBefore(ls, Utils.makeDate(1999, 11, 1),"СМ");
		Period st4=getMedStajAfter(ls, Utils.makeDate(1999, 11, 1),"СМ");
		
		Period st5=getMedStajBefore(ls, Utils.makeDate(1999, 11, 1),"ГДХР").multPeriod(1.5f);
		Period st6=getMedStajAfter(ls, Utils.makeDate(1999, 11, 1),"ГДХР").multPeriod(1.5f);
		
		Period st7=getMedStajBefore(ls, Utils.makeDate(1999, 11, 1),"ГД");
		Period st8=getMedStajAfter(ls, Utils.makeDate(1999, 11, 1),"ГД");
		
		boolean containsCity=!st5.isEmpty()||!st6.isEmpty()||!st7.isEmpty()||!st8.isEmpty();
		if (what.equals("СМ")) {
			if (!containsCity) st4=st4.multPeriod(1.25f);
		}
		
		if (what.equals("СМХР")) {
			if (!containsCity) {
			st1=st1.multPeriod(1.5f);
			st2=st2.multPeriod(1.5f);
			}
			else
			{
				st1=st1.multPeriod(1.75f);
				st2=st2.multPeriod(1.75f);
			}
		}
		
		
		
		//Period atAll=getMedStajBefore(ls, Utils.makeDate(2100, 1, 1));
		
		return getMedStajBefore(ls, Utils.makeDate(2100, 1, 1), containsCity);
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

	public Period getMedStaj(List<Staj> stl,String vid) {
	LgotaDescription lg=lDao.getLgota(vid);
	if (stl==null) return new Period(0,0,0);
	List<Staj> sttmp=new ArrayList<Staj>();
	float stavka;
	Staj current,stg1=null;
	Date dfrom=Utils.makeDate(1999,11,1);
	//отбираем только с нужным кодом которые или имеют ставку или до 01-11-1999г.
	for (Staj st: stl) {
		
		if (inList(lg,st.getCspext()))
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
			if (stavka>0) {
				current.setStavka(stavka);
				sttmp.add(current);
			}
		}
	
	}
	if (sttmp.isEmpty()) return new Period(0,0,0);
	Collections.sort(sttmp);
	List<Staj> toadd1=new ArrayList<Staj>();
	List<Staj> toadd2=new ArrayList<Staj>();
	List<Staj> toadd3=new ArrayList<Staj>();
	int counter;
	boolean st,fn;
	boolean changed;
	for (Staj s0:sttmp) toadd1.add(Staj.makeCopy(s0));
	for (Staj s0:sttmp) toadd2.add(Staj.makeCopy(s0));
	//int cycles=0;
	
	while(true)
	{
	changed=false;	
	for (Staj s1:toadd1) {
		toadd3.clear();
		for (Staj s2:toadd2) {
			if (Utils.intersect(s1.getStartDate(),s1.getEndDate(),s2.getStartDate(),s2.getEndDate())) {
				changed=true;
				current=Staj.makeCopy(s1);
				st=false;
				fn=false;
				if (Utils.beforeOrEqual(s1.getStartDate(),s2.getStartDate()))
				{
					current.setStartDate(s2.getStartDate());
					s1.setEndDate(Utils.addDay(s2.getStartDate(),-1));
					st=true;
				}
				
				if (Utils.beforeOrEqual(s2.getEndDate(),s1.getEndDate())) {
					current.setEndDate(s2.getEndDate());
					s1.setStartDate(Utils.addDay(s2.getEndDate(),1));
					fn=true;
				}
				if (!st&&!fn) s1.setStartDate(s1.getEndDate());//если e s1 ничего не обрезалось, он внутри полностью - обнуляем его
				
				if (Utils.beforeOrEqual(s2.getStartDate(), current.getStartDate())) {
					
				}
				setLgota(current,s1,s2);
				toadd3.add(current);
				}
			}
		toadd2.addAll(toadd3);
		}
	if (!changed) break;
	}
	
	
	
	
	while(true)
	


	{
	toadd.clear();
	counter=0;
	current=sttmp.get(0);
	for (Staj st1: sttmp) {
		counter++;
		if (counter==1 || !st1.getStartDate().before(st1.getEndDate())) continue;
		changed=false;
		
		if (Utils.intersect(current.getStartDate(),st1.getStartDate(),current.getEndDate(),st1.getEndDate())) {
			if (Utils.beforeOrEqual(current.getStartDate(),st1.getStartDate())) {
				if (Utils.beforeOrEqual(current.getEndDate(),st1.getEndDate())){
					
				}
				else {
					
				}
			}
			else {
				
			}
		}
		
		if (Utils.afterOrEqual(current.getEndDate(),st1.getStartDate()))
		{
			if (current.getEndDate().before(st1.getEndDate()))
			{//порождается часть от st
				stg1=Staj.makeCopy(st1);
				stg1.setStartDate(Utils.addDay(current.getEndDate(),1));
				st1.setEndDate(current.getEndDate());
				st1.setAddDay(0);
			}
			else
			{
				stg1=Staj.makeCopy(current);
				stg1.setStartDate(Utils.addDay(st1.getEndDate(),1));
			}
			changed=stg1.getStartDate().before(stg1.getEndDate());
			if (st1.getStavka()<1) selectMedStaj(st1,current);
			st1.setStavka(st1.getStavka()+current.getStavka());
			
			current.setEndDate(Utils.addDay(st1.getStartDate(),-1));
			current.setAddDay(0);
		}
		
		
		if (changed) toadd.add(stg1);
		current=st1;
	}
	if (toadd.isEmpty()) break;
//	cycles+=1;
//	System.out.println("cycles="+cycles+" lgh="+toadd.size());
	sttmp.addAll(toadd);
	Collections.sort(sttmp);
	}
	
	sttmp.removeIf(x->(x.getStavka()<0.999f|| !x.getStartDate().before(x.getEndDate())));
//	boolean containsCity=false;
//	for (Staj st: sttmp) {
////		System.out.println(st);
//		if (st.getCspext().contains("ГД")) {
//			containsCity=true;
//			break;
//		}
//		
//	}
	return getMedStajAll(sttmp);
}

	
private void setLgota(Staj current, Staj s1, Staj s2) {
	// TODO Auto-generated method stub
	
}



	private String selectMedStaj(Staj a, Staj b) {
	if (a.getCspext().equals("27-ГД")||b.getCspext().equals("27-ГД")) return "27-ГД";
	else if (a.getCspext().equals("27-СМ")||b.getCspext().equals("27-СМ")) return "27-СМ";
	else if (a.getCspext().equals("27-ГДХР")||b.getCspext().equals("27-ГДХР")) return "27-ГДХР";
	else if (a.getCspext().equals("27-СМХР")||b.getCspext().equals("27-СМХР")) return "27-СМХР";
	else return "";
}
	
}
