package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yss1.one.models.Staj;
import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

//Калькулятор расчета медицинского стажа
@Service
public class MedCalculator {
	public Period getMedStajBefore(List<Staj> ls, Date bd, boolean containsCity) {
		// what=1 ГД,what=2 СМ, what=3 ГДХР, what=4 СМХР

		Period per = new Period(0, 0, 0);
		Date border = Utils.makeDate(1999, 11, 1);
		for (Staj st : ls) {
			if (st.getStartDate().after(bd))
				continue;
			
			if (st.getCspext().contains("СМХР")) {
				if (containsCity) {
					if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
						per.addPeriod(Utils.multPeriod(
								Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.75f));
					} else {
						per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.75f));
					}
				} else {
					if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
						per.addPeriod(Utils.multPeriod(
								Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.5f));
					} else {
						per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.5f));
					}
				}
				
			} else if (st.getCspext().contains("ГДХР")) {
				if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
					per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()),1.5f));
				} else {
					per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.5f));
				}

			} else if (st.getCspext().contains("СМ")) {
				if (containsCity) {
					if (st.getStartDate().before(border)) {
						if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
							per.addPeriod(Utils.multPeriod(
									Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.25f));
						} else {
							per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.25f));
						}
					} else {
						if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
							per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
						} else {
							per.addPeriod(Utils.makePeriod(st.getStartDate(), bd, 0));
						}
					}
				} else {
					if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
						per.addPeriod(Utils.multPeriod(
								Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()), 1.25f));
					} else {
						per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), bd, 0), 1.25f));
					}
				}
				
			} else if (st.getCspext().contains("ГД")) {
				if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
					per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
				} else {
					per.addPeriod(Utils.makePeriod(st.getStartDate(), bd, 0));
				}
			}

		}
		return per;
	}

	public Period getMedStajAll(List<Staj> ls, boolean containsCity) {
		return getMedStajBefore(ls, Utils.makeDate(2100, 1, 1), containsCity);
	}



	public Period getMedStaj(List<Staj> stl,List<String> vidl) {
	
	if (stl==null) return new Period(0,0,0);
	List<Staj> sttmp=new ArrayList<Staj>();
	float stavka;
	Staj current,stg1=null;
	Date dfrom=Utils.makeDate(1999,11,01);
	//отбираем только с нужным кодом которые или имеют ставку или до 10-11-1999г.
	for (Staj st: stl) {
		
		if (vidl.contains(st.getCspext()))
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
	List<Staj> toadd=new ArrayList<Staj>();
	int counter;
	boolean changed;
	
	int cycles=0;
	
	while(true)
	{
	toadd.clear();
	counter=0;
	current=sttmp.get(0);
	for (Staj st1: sttmp) {
		counter++;
		if (counter==1 || !st1.getStartDate().before(st1.getEndDate())) continue;
		changed=false;
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
	cycles+=1;
	System.out.println("cycles="+cycles+" lgh="+toadd.size());
	sttmp.addAll(toadd);
	Collections.sort(sttmp);
	}
	
	sttmp.removeIf(x->(x.getStavka()<0.999f|| !x.getStartDate().before(x.getEndDate())));
	boolean containsCity=false;
	for (Staj st: sttmp) {
		System.out.println(st);
		if (st.getCspext().contains("ГД")) {
			containsCity=true;
			
			//break;
		}
		
	}
	return getMedStajAll(sttmp, containsCity);
}

	private String selectMedStaj(Staj a, Staj b) {
	if (a.getCspext().equals("27-ГД")||a.getCspext().equals("27-ГД")) return "27-ГД";
	else if (a.getCspext().equals("27-СМ")||a.getCspext().equals("27-СМ")) return "27-СМ";
	else if (a.getCspext().equals("27-ГДХР")||a.getCspext().equals("27-ГДХР")) return "27-ГДХР";
	else if (a.getCspext().equals("27-СМХР")||a.getCspext().equals("27-СМХР")) return "27-СМХР";
	else return "";
}
	
}
