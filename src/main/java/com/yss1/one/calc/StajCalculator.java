package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.LgotaDao;
import com.yss1.one.dao.LgtCodesDao;
import com.yss1.one.models.Deyatelnost;
import com.yss1.one.models.Staj;
import com.yss1.one.models.Vsnos;
import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

@Service
public class StajCalculator {
	
@Autowired
LgtCodesDao lgtCodesDao;

@Autowired
LgotaDao lgotaDao;

Set<String> lgotes;


public Set<String> getLgotes() {
	return lgotes;
}

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
		lgotes=lgotaDao.checkLgotes(result);//получение списка всех льгот
		return result;
	}

public List<Deyatelnost> getPredprStaj(List<Staj> stlist, List<Vsnos> vsnosy){
	List<Deyatelnost> tmp = new ArrayList<>();
    boolean have;
	for (Staj st: stlist) {
		have=false;
		for (Deyatelnost sp: tmp) {
			if (st.getPredprName().equals(sp.getPredprName()) && Utils.addDay(sp.getdEnd(),3).after(st.getStartDate()))
			{
				if (!st.getRegNumb().isEmpty()) sp.setRegNumb(st.getRegNumb()); 
				if (st.getEndDate().after(sp.getdEnd()))
				{
					sp.setdEnd(st.getEndDate());
				}
				have=true;
				break;
			}
		}
		if (!have) tmp.add(Deyatelnost.fromStaj(st));
	}
	//Collections.sort(tmp);
	Collections.sort(tmp, new Comparator<Deyatelnost>() {
        public int compare(Deyatelnost o1, Deyatelnost o2) {
                return o1.getdEnd().compareTo(o2.getdEnd());
        }
});
	
	for (Vsnos vs: vsnosy) {
		for (Deyatelnost sp: tmp) {
			if (vs.getRegNumb().equals(sp.getRegNumb())) sp.setSumm(sp.getSumm()+vs.getAsr()); 
		}
	}
	return tmp;
}
	
//упорядычеваем записи о стаже, исключаем перекрывающиеся участки, сливаем
public List<Staj> orderStajRecords(List<Staj> stlist,List<Staj> stklist)
{
List<Staj> tmp = new ArrayList<>();
Staj last = null;
Staj end = null;
Staj st = null;

if (stlist!=null && !stlist.isEmpty()) {
	end = Staj.makeCopy(stlist.get(stlist.size() - 1));
}
for (Staj st1 : stlist) {
	st=Staj.makeCopy(st1);
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


if (stklist!=null && !stklist.isEmpty())
{
List<Staj> stkl=new ArrayList<>();
for (Staj s:stklist) stkl.add(Staj.makeCopy(s));	
List<Staj> current = new ArrayList<>(stkl);
stkl.clear();

while (current.size() > 0) {
	stkl.addAll(current);
	current.clear();
	for (Staj stKonv : stkl) {
		
		if (skipThis(stKonv) || !(stKonv.getStartDate().before(stKonv.getEndDate())))
			continue;
		for (Staj st1 : tmp) {
			last = cutStajes(stKonv, st1);
			if (last != null && !current.contains(last))
				current.add(last);
		}
	}
}

for (Staj stKonv : stkl) {
	if (stKonv.getEndDate().after(stKonv.getStartDate()) && !skipThis(stKonv))
	{
		tmp.add(stKonv);
	}
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
