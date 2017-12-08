package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.LgtCodesDao;
import com.yss1.one.models.Staj;
import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

@Service
public class StajCalculator {
	
@Autowired
LgtCodesDao lgtCodesDao;

//функция расчета стажа на указанную дату	
public Period getStajBefore(List<Staj> ls, Date bd) {
		Period per = new Period(0, 0, 0);
		for (Staj st : ls) {
			if (st.getStartDate().after(bd))
				continue;
			if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
				per.addPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
			} else {
				per.addPeriod(Utils.makePeriod(st.getStartDate(), bd, 0));
			}
		}
		return per;
	}

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
					per.addPeriod(Utils.multPeriod(Utils.makePeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()),
							1.5f));
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

	// функция расчета общего стажа
	public Period getStajAll(List<Staj> ls) {
		return getStajBefore(ls, Utils.makeDate(2100, 1, 1));
	}

	public List<Staj> copyStajes(List<Staj> stl, List<Staj> stkl) {
		List<Staj> result = new ArrayList<>();
		if (stl != null)
			for (Staj st : stl)
				result.add(new Staj(st));
		if (stkl != null)
			for (Staj st : stkl)
				result.add(new Staj(st));
		Collections.sort(result);
		lgtCodesDao.updateCodes(result);// замена кодов на актуальные
		return result;
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
	else if (a.getCspext().equals("27-СМХР")||a.getCspext().equals("27-СМХР")) return "27-СМНР";
	else return "";
}


public Period getPedStaj(List<Staj> stl) {
	
	if (stl==null) return new Period(0,0,0);
	List<Staj> sttmp=new ArrayList<Staj>();
	float stavka;
	Staj current,stg1=null;
	Date dfrom=Utils.makeDate(2000,9,1);
	//отбираем только с нужным кодом которые или имеют ставку или до 01-09-2000г.
	for (Staj st: stl) {
		if (st.getCspext().contains("27-ПД"))
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
			{
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
	
	return getStajAll(sttmp);
}





//упорядычеваем записи о стаже, исключаем перекрывающиеся участки, сливаем
public List<Staj> orderStajRecords(List<Staj> stl,List<Staj> stkl)
{
List<Staj> tmp = new ArrayList<>();
Staj last = null;
Staj end = null;
if (stl!=null && !stl.isEmpty()) {
	end = stl.get(stl.size() - 1);
}
for (Staj st : stl) {

	if (skipThis(st))
		continue;

	if (last == null || last.getEndDate().before(st.getStartDate())) {
		if (last != null)
			tmp.add(last);
		last = st;
	} else {
		mergeStajes(last, st);
	}
	if (st == end)
		tmp.add(last);
}

if (stkl!=null && !stkl.isEmpty())
{
List<Staj> current = new ArrayList<>(stkl);
stkl.clear();

while (current.size() > 0) {
	stkl.addAll(current);
	current.clear();
	for (Staj stKonv : stkl) {
		if (skipThis(stKonv) || !(stKonv.getStartDate().before(stKonv.getEndDate())))
			continue;
		for (Staj st : tmp) {
			last = cutStajes(stKonv, st);
			if (last != null && !current.contains(last))
				current.add(last);
		}
	}
}

for (Staj stKonv : stkl) {
	if (stKonv.getEndDate().after(stKonv.getStartDate()) && !skipThis(stKonv))
		tmp.add(stKonv);
}
}

Collections.sort(tmp);
return tmp;
}

//Вспомогательные функции
//то, что не надо учитывать
private boolean skipThis(Staj s) {
	if (s.getDopctpext() != null && s.getDopctpext().contains("АДМИНИСТР") 
			&& s.getEndDate().after(Utils.makeDate(2001, 12, 31))) {
		if (s.getStartDate().before(Utils.makeDate(2002, 1, 1))) {
			s.setEndDate(Utils.makeDate(2001, 12, 31));
		} else {
			return true;
		}
	}
	if (s.getVidDeyat() != null && s.getVidDeyat().contains("ДВСТО") || s.getDopctpext()!=null && s.getDopctpext().contains("НЕОПЛ")) {
		return true;
	}
	return false;
}

//сливаем 2 периода, если перекрываюься
private boolean mergeStajes(Staj s1, Staj s2) {
	if (Utils.intersect(s1.getStartDate(), s1.getEndDate(), s2.getStartDate(), s2.getEndDate())) {
		s1.setStartDate(s1.getStartDate().before(s2.getStartDate()) ? s1.getStartDate() : s2.getStartDate());
		s1.setEndDate(s1.getEndDate().after(s2.getEndDate()) ? s1.getEndDate() : s2.getEndDate());
		return true;
	}
	return false;
}

private Staj cutStajes(Staj s1, Staj s2) {// из s1 выкусываем s2 получаем 0 1 или 2 отрезка возвращаем период, если
											// образовался в случае 2х
	if (Utils.intersect(s1.getStartDate(), s1.getEndDate(), s2.getStartDate(), s2.getEndDate())) {
		if (Utils.included(s2.getStartDate(), s2.getEndDate(), s1.getStartDate(), s1.getEndDate())) {// поглащен
			s1.setStartDate(s1.getEndDate());
			return null;
		} else if (Utils.included(s1.getStartDate(), s1.getEndDate(), s2.getStartDate(), s2.getEndDate())) {// внутри
																											// -
																											// разбиваем
																											// на 2
			Staj s0 = new Staj(s1);
			s0.setEndDate(Utils.addDay(s2.getStartDate(), -1));
			s0.setAddDay(0);
			if (!s0.getStartDate().before(s0.getEndDate()))
				s0 = null;

			s1.setStartDate(Utils.addDay(s2.getEndDate(), 1));
			s1.setAddDay(1);

			return s0;
		} else if (s1.getStartDate().before(s2.getStartDate())) {
			s1.setEndDate(Utils.addDay(s2.getStartDate(), -1));
			s1.setAddDay(0);
			return null;
		} else {// s1.getEndDate().after(s2.getEndDate())
			s1.setStartDate(Utils.addDay(s2.getEndDate(), 1));
			s1.setAddDay(1);
			return null;
		}
	}
	return null;
}



}
