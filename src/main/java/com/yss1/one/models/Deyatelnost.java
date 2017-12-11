package com.yss1.one.models;

import java.util.Date;

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
	private String harDeyat;

	//конструируем деятельность на основе стажа
	public static Deyatelnost fromStaj(Staj st) {
		Deyatelnost dey = new Deyatelnost();
		dey.dStart = st.getStartDate();
		dey.dEnd = st.getEndDate();
		dey.regNumb = st.getRegNumb();
		dey.predprName = st.getPredprName();
		dey.vidDeyat = st.getVidDeyat();
		return dey;
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

	public String getHarDeyat() {
		return harDeyat;
	}

	public void setHarDeyat(String harDeyat) {
		this.harDeyat = harDeyat;
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
