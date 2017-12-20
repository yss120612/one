package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.models.Staj;
import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

//сервис расчета педагогического стажа
@Service
public class PedCalculator {
@Autowired
StajCalculator stCalc;

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

//int cycles=0;
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
//cycles+=1;
//System.out.println("cycles="+cycles+" lgh="+toadd.size());
sttmp.addAll(toadd);
Collections.sort(sttmp);
}

sttmp.removeIf(x->(x.getStavka()<0.999f|| !x.getStartDate().before(x.getEndDate())));

return stCalc.getStajAll(sttmp);
}


}
