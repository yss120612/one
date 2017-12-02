package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yss1.one.models.Staj;
import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

@Service
public class StajCalculator {
	
//функция расчета стажа на указанную дату	
public Period getStajBefore(List<Staj> ls, Date bd) {
		Period per = new Period(0, 0, 0);
		for (Staj st : ls) {
			if (st.getStartDate().after(bd))
				continue;
			if (Utils.beforeOrEqual(st.getEndDate(), bd)) {
				per.addPeriod(Utils.calcPeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
			} else {
				per.addPeriod(Utils.calcPeriod(st.getStartDate(), bd, 0));
			}
		}
		return per;
	}

//функция расчета общего стажа
public Period getStajAll(List<Staj> ls) {
	return getStajBefore(ls, Utils.makeDate(2100, 1, 1));
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
