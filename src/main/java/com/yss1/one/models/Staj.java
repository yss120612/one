package com.yss1.one.models;

import java.util.Date;

import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

public class Staj implements Comparable<Staj>{
	
@Override
	public String toString() {
		period=Utils.calcPeriod(startDate,endDate);
		return "Staj [startDate=" + Utils.getFormattedDate(startDate) + ", endDate=" + Utils.getFormattedDate(endDate) + "\ncggext=" + cggext + ", cwcext=" + cwcext
				+ ", ctpext=" + ctpext + ", dopctpext=" + dopctpext + ", cspext=" + cspext + ", vidDeyat=" + vidDeyat + " period="+period.toString()+"]";
				
	}

private Date startDate;
private Date endDate;

private Period period;

//Территориальные условия (РКС/МКС)
private String cggext;

//Особые условия(27-1 и т.д.)
private String  cwcext;

//Исчесляемый стаж - Основание(код)
private String  ctpext;

//Дополнительные сведения  dopcspext d в другой 
private String  dopctpext;

//Выслуга лет - Основание(код) в другой таблице cspcod
private String cspext;

//Дополнительные сведения  dopcspext d в другой 
private String  dopcspext;

//вид деятельности
private String vidDeyat;

public String getVidDeyat() {
	return vidDeyat;
}

public void setVidDeyat(String vidDeyat) {
	this.vidDeyat = vidDeyat;
}

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

public String getCggext() {
	return cggext;
}

public void setCggext(String cggext) {
	this.cggext = cggext;
}

public String getCwcext() {
	return cwcext;
}

public void setCwcext(String cwcext) {
	this.cwcext = cwcext;
}

public String getCtpext() {
	return ctpext;
}

public void setCtpext(String ctpext) {
	this.ctpext = ctpext;
}

public String getDopctpext() {
	return dopctpext;
}

public void setDopctpext(String dopctpext) {
	this.dopctpext = dopctpext;
}

public String getCspext() {
	return cspext;
}

public void setCspext(String cspext) {
	this.cspext = cspext;
}

public String getDopcspext() {
	return dopcspext;
}

public void setDopcspext(String dopcspext) {
	this.dopcspext = dopcspext;
}

@Override
public int compareTo(Staj staj) {
	if (staj==null || staj.startDate==null)
	{
		return 0;
	}
	return startDate.compareTo(staj.startDate);
}


}
