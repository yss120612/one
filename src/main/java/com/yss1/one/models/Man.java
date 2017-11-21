package com.yss1.one.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

public class Man {

	String name;
	String family;
	String otch;
	Date birthDay;
	String SNILS;
	Period period;
	List<Staj> staj;
	List<Staj> stajKonv;
	public String res;

	private boolean skipThis(Staj s) {
		if (s.getDopctpext() != null
				&& (s.getDopctpext().contains("АДМИНИСТР") || s.getDopctpext().contains("АДМИНИСТР"))
				&& s.getEndDate().after(Utils.makeDate(2001, 12, 31))) {
			if (s.getStartDate().before(Utils.makeDate(2002, 1, 1))) {
				s.setEndDate(Utils.makeDate(2001, 12, 31));
			} else {
				return true;
			}
		}
		if (s.getVidDeyat() != null && s.getVidDeyat().contains("ДВСТО")) {
			return true;
		}
		return false;
	}

	public boolean mergeStajes(Staj s1, Staj s2) {
		if (Utils.intersect(s1.getStartDate(), s1.getEndDate(), s2.getStartDate(), s2.getEndDate())) {
			s1.setStartDate(s1.getStartDate().before(s2.getStartDate()) ? s1.getStartDate() : s2.getStartDate());
			s1.setEndDate(s1.getEndDate().after(s2.getEndDate()) ? s1.getEndDate() : s2.getEndDate());
			return true;
		}
		return false;
	}

	public boolean cutStajes(Staj s1, Staj s2, Staj so2) {// из s1 выкусываем s2 получаем 0 1 или 2 отрезка

		if (Utils.intersect(s1.getStartDate(), s1.getEndDate(), s2.getStartDate(), s2.getEndDate())) {
			if (Utils.included(s2.getStartDate(), s2.getEndDate(), s1.getStartDate(), s1.getEndDate())) {
				s1.setStartDate(s1.getEndDate());
				so2 = null;
				return false;
			} else if (Utils.included(s1.getStartDate(), s1.getEndDate(), s2.getStartDate(), s2.getEndDate())) {
				Staj s0 = new Staj(s1);
				s0.setEndDate(Utils.addDay(s2.getStartDate(), -1));
				s0.setAddDay(0);
				s1.setStartDate(Utils.addDay(s2.getEndDate(), 1));
				s1.setAddDay(0);
				if (s0.getStartDate().before(s0.getEndDate()))
					so2 = s0;
				if (s1.getStartDate().before(s1.getEndDate()))
					return true;
			} else if (s1.getStartDate().before(s2.getStartDate())) {
				s1.setEndDate(Utils.addDay(s2.getStartDate(), -1));
				s1.setAddDay(0);
				so2 = null;
				return true;
			} else {// s1.getEndDate().after(s2.getEndDate())
				s1.setStartDate(Utils.addDay(s2.getEndDate(), 1));
				s1.setAddDay(0);
				so2 = null;
				return true;
			}
		}
		so2 = null;
		return true;
	}

	public void calcStaj() {
		if (staj == null || staj.isEmpty()) {
			return;
		}

		sort();
		List<Staj> tmp = new ArrayList<>();
		Staj last = null;
		Staj end = null;
		if (!staj.isEmpty()) {
			end = staj.get(staj.size() - 1);
		}
		for (Staj st : staj) {

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

		List<Staj> current = new ArrayList<>(stajKonv);
		stajKonv.clear();

		while (current.size() > 0) {
			stajKonv.addAll(current);
			current.clear();
			for (Staj stKonv : stajKonv) {
				if (skipThis(stKonv))
					continue;
				for (Staj st : tmp) {
					cutStajes(stKonv, st, last);
					if (last != null && !current.contains(last))
						current.add(last);
				}
			}
		}

		for (Staj stKonv : stajKonv) {
			if (stKonv.getEndDate().after(stKonv.getStartDate())&& !skipThis(stKonv))
				tmp.add(stKonv);
		}

		Collections.sort(tmp);
		period = new Period(0, 0, 0);
		res = "";
		for (Staj st : tmp) {
			period.addPeriod(Utils.calcPeriod(st.getStartDate(), st.getEndDate()));
			res = res + st.toString() + "<br>";
		}

	}

	public Period getPeriod() {
		return period;
	}

	public String getName() {
		return name;
	}

	public void sort() {
		Collections.sort(staj);
		Collections.sort(stajKonv);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getOtch() {
		return otch;
	}

	public void setOtch(String otch) {
		this.otch = otch;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getSNILS() {
		return SNILS;
	}

	public void setSNILS(String sNILS) {
		SNILS = sNILS;
	}

	public void setFio(String fio) {
		fio = fio.trim().replaceAll("\\s+", " ");
		String[] afio = fio.split(" ");
		if (afio.length > 1) {
			family = afio[0];
			name = afio[1];
		}
		if (afio.length > 2) {
			otch = afio[2];
		}
	}

	public List<Staj> getStaj() {
		return staj;
	}

	public void setStaj(List<Staj> staj) {
		this.staj = staj;
	}

	public void setStajKonv(List<Staj> staj) {
		this.stajKonv = stajKonv;
	}

	public String getFormattedBirthday() {
		return Utils.getFormattedDate(birthDay);
	}
}
