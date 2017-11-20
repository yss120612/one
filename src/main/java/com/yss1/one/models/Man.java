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
	
	public void calcStaj()
	{
		if (staj==null || staj.isEmpty())
		{
			return;
		}
		
		sort();
		List<Staj> tmp=new ArrayList<>();
		Staj last=null;
		for (Staj st:staj) {
			
			if (st.getDopctpext()!=null && (st.getDopctpext().contains("АДМИНИСТР") || st.getDopctpext().contains("АДМИНИСТР")) && st.getEndDate().after(Utils.makeDate(2001, 12 ,31))) {
				if (st.getStartDate().before(Utils.makeDate(2002, 1 ,1))) {
					st.setEndDate(Utils.makeDate(2001, 12 ,31));
				}else
				{
				continue;	
				}
			}
			if (st.getVidDeyat().contains("ДВСТО")) {
				continue;
			}
			
			
			if (last==null || last.getEndDate().before(st.getStartDate()))
			{
				if (last!=null) tmp.add(last);
				last=st;
			}else {
				last.setStartDate(last.getStartDate().before(st.getStartDate())?last.getStartDate():st.getStartDate());
				last.setEndDate(last.getEndDate().after(st.getEndDate())?last.getEndDate():st.getEndDate());
			}
		}
		Staj end;
		if (staj.size()>0)
		{
		end=staj.get(staj.size()-1);
		if (end!=last)
		{
		last.setStartDate(last.getStartDate().before(end.getStartDate())?last.getStartDate():end.getStartDate());
		last.setEndDate(last.getEndDate().after(end.getEndDate())?last.getEndDate():end.getEndDate());
		tmp.add(last);
		}
		}
		
		Collections.sort(tmp);
		period=new Period(0,0,0);
		//String res;
		res="";
		for (Staj st:tmp)
		{
			period.addPeriod(Utils.calcPeriod(st.getStartDate(),st.getEndDate()));
			res=res+st.toString()+"<br>";
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
