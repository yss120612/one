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
	String sex;
	Date birthDay;
	String SNILS;
	Period periodAll, period1991, period2002, period2015;
	List<Staj> staj;
	List<Staj> stajKonv;
	public String res;
	float kVal;
	float stajK;
	float dopStajK;
	List<Platej> plateg20002001;
	
	
	public List<Platej> getPlateg20002001() {
		return plateg20002001;
	}

	public void setPlateg20002001(List<Platej> plateg20002001) {
		this.plateg20002001 = plateg20002001;
	}

	private boolean skipThis(Staj s) {
		if (s.getDopctpext() != null && (s.getDopctpext().contains("АДМИНИСТР") || s.getDopctpext().contains("НЕОПЛ"))
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

	private boolean mergeStajes(Staj s1, Staj s2) {
		if (Utils.intersect(s1.getStartDate(), s1.getEndDate(), s2.getStartDate(), s2.getEndDate())) {
			s1.setStartDate(s1.getStartDate().before(s2.getStartDate()) ? s1.getStartDate() : s2.getStartDate());
			s1.setEndDate(s1.getEndDate().after(s2.getEndDate()) ? s1.getEndDate() : s2.getEndDate());
			return true;
		}
		return false;
	}

	private Staj cutStajes(Staj s1, Staj s2) {// из s1 выкусываем s2 получаем 0 1 или 2 отрезка возвращаем кусок, если
												// образовался
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

	private Period getStajBefore(List<Staj> ls, Date bd) {
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
				if (skipThis(stKonv) || !(stKonv.getStartDate().before(stKonv.getEndDate())))
					continue;
				for (Staj st : tmp) {
					last = cutStajes(stKonv, st);
					if (last != null && !current.contains(last))
						current.add(last);
				}
			}
		}

		for (Staj stKonv : stajKonv) {
			if (stKonv.getEndDate().after(stKonv.getStartDate()) && !skipThis(stKonv))
				tmp.add(stKonv);
		}

		Collections.sort(tmp);
		periodAll = new Period(0, 0, 0);
		res = "";
		period1991 = getStajBefore(tmp, Utils.makeDate(1990, 12, 31));
		period2002 = getStajBefore(tmp, Utils.makeDate(2001, 12, 31));
		period2015 = getStajBefore(tmp, Utils.makeDate(2014, 12, 31));
		calcKVal();
		calcStajK();
		res = "p1991=" + period1991 + " p2002=" + period2002 + " p2015=" + period2015+" KVal="+kVal+" StajK="+stajK+" ponStajK="+dopStajK+"<br>";
		for (Platej pl : plateg20002001) {
			res = res + pl.toString() + "<br>";
		}
		for (Staj st : tmp) {
			periodAll.addPeriod(Utils.calcPeriod(st.getStartDate(), st.getEndDate(), st.getAddDay()));
			res = res + st.toString() + "<br>";
		}
		
		

	}

	public void calcKVal() {
		kVal = 0.1f;
		if (period1991 == null)
			return;
		kVal = (0.1f + 0.01f * period1991.getYears());
	}

	public void calcStajK() {
		stajK = 0.55f;
		dopStajK = 1f;
		int need = sex.toUpperCase().contains("М") ? 25 : 20;
		if (period2002.getYears() > need) {
			stajK += (period2002.getYears() - need) * 0.01f;
			if (stajK > 0.75f)
				stajK = 0.75f;
		} else {
			dopStajK = (period2002.getYears() * 12 + period2002.getMonths() + period2002.getDays() / 30f) / (need * 12f);
		}
	}

	public Period getPeriod() {
		return periodAll;
	}

	public String getName() {
		return name;
	}

	public void sort() {
		if (staj != null)
			Collections.sort(staj);
		if (stajKonv != null)
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

	public List<Staj> getStajKonv() {
		return stajKonv;
	}

	public void setStaj(List<Staj> staj) {
		this.staj = staj;
	}

	public void setStajKonv(List<Staj> staj) {
		this.stajKonv = staj;
	}

	public String getFormattedBirthday() {
		return Utils.getFormattedDate(birthDay);
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
