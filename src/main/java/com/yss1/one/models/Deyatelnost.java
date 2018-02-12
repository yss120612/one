package com.yss1.one.models;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

//деятельность на предприятии
public class Deyatelnost {
	// начало деятельности
	private Date dStart;
	// конец деятельности
	private Date dEnd;
	// рег номер страхователя в системе ПФР
	private String regNumb;
	// наименование предприятия
	private String predprName;
	// вид деятельности
	private String vidDeyat;
	// харрактеристика деятельности
	private Set<String> harDeyat;

	//конструируем деятельность на основе стажа
	public static Deyatelnost fromStaj(Staj st) {
		Deyatelnost dey = new Deyatelnost();
		dey.dStart = st.getStartDate();
		dey.dEnd = st.getEndDate();
		dey.regNumb = st.getRegNumb();
		dey.predprName = st.getPredprName();
		dey.vidDeyat = st.getVidDeyat();
		dey.addHarDeyat(st);
		return dey;
	}

	//добавляем лготу из стажа, если надо
	public void addHarDeyat(Staj st) {
		addHarDeyat(st.getCspext());
		addHarDeyat(st.getCwcext());
		addHarDeyat(st.getCggext());
	}
	
	public boolean myVsnos(Vsnos v) {
		GregorianCalendar cal=new GregorianCalendar();
		cal.setTime(dStart);
		int y0=cal.get(GregorianCalendar.YEAR);
		cal.setTime(dEnd);
		int y1=cal.get(GregorianCalendar.YEAR);
		return (v.getYear()>=y0 && v.getYear()<=y1 && v.getRegNumb().equals(regNumb));
	}
	
	
	@Override
	public String toString() {
		return "Deyatelnost [dStart=" + Utils.getFormattedDate(dStart) + ", dEnd=" + Utils.getFormattedDate(dEnd) + ", regNumb=" + regNumb + ", predprName="
				+ predprName + ", vidDeyat=" + vidDeyat + ", harDeyat=" + harDeyat + ", Stag=" + getPeriod() + ", summ=" + summ + "]";
	}



	private Period getPeriod() {
		return  Utils.makePeriod(dStart, dEnd, 1);
	}



	public Date getdStart() {
		return dStart;
	}

	public void setdStart(Date dStart) {
		this.dStart = dStart;
	}

	public Date getdEnd() {
		return dEnd;
	}

	public void setdEnd(Date dEnd) {
		this.dEnd = dEnd;
	}

	public String getRegNumb() {
		return regNumb;
	}

	public void setRegNumb(String regNumb) {
		this.regNumb = regNumb;
	}

	public String getPredprName() {
		return predprName;
	}

	public void setPredprName(String predprName) {
		this.predprName = predprName;
	}

	public String getVidDeyat() {
		return vidDeyat;
	}

	public void setVidDeyat(String vidDeyat) {
		this.vidDeyat = vidDeyat;
	}

	public String getHarDeyatStr() {
		String res="";
		for (String s: harDeyat) {
			if (s.equals("/")) continue;
			res+=(res.isEmpty()?s:", "+s);
		}
		return res;
	}

	public void addHarDeyat(String har) {
		if (harDeyat==null) harDeyat=new HashSet<>();
		if (har==null || har.isEmpty() || harDeyat.contains(har)) return;
		harDeyat.add(har);
	}

	public float getSumm() {
		return summ;
	}

	public void setSumm(float summ) {
		this.summ = summ;
	}

	// сумма уплаченных взносонв
	private float summ;

}
