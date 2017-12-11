package com.yss1.one.models;

import java.util.Date;

import com.yss1.one.util.Period;
import com.yss1.one.util.Utils;

public class Staj implements Comparable<Staj>{
	
@Override
	public String toString() {
		period=Utils.makePeriod(startDate,endDate,addDay);
//		return "Staj [startDate=" + Utils.getFormattedDate(startDate) + ", endDate=" + Utils.getFormattedDate(endDate) + "\ncggext=" + cggext + ", cwcext=" + cwcext
//				+ ", ctpext=" + ctpext + ", dopctpext=" + dopctpext + ", cspext=" + cspext + ", vidDeyat=" + vidDeyat + " period="+period.toString()+"]";
		return "Staj [startDate=" + Utils.getFormattedDate(startDate) + ", endDate=" + Utils.getFormattedDate(endDate) + ", ctpext=" + ctpext + ", dopctpext=" + dopctpext + ", cspext=" + cspext + ", dopcspext="+ dopcspext +", stavka=" + stavka + " period="+period.toString()+ " <br>VID="+vidDeyat+" ORG="+predprName+"]";
				
	}

private String predprName;

public String getPredprName() {
	return predprName;
}

public void setPredprName(String predprName) {
	this.predprName = predprName==null?"":predprName.trim();
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


//день прибавляем?
private int addDay;

//ставка
private float stavka;

//служебное поле
private int flag;

//рег номер работодателя
private String regNumb;

public String getRegNumb() {
	return regNumb;
}
public void setRegNumb(String regNumb) {
	this.regNumb = regNumb==null?"":regNumb.trim();
}



public int getFlag() {
	return flag;
}

public void setFlag(int flag) {
	this.flag = flag;
}

public float getStavka() {
	return stavka;
}

public void setStavka(float stavka) {
	this.stavka = stavka;
}

public int getAddDay() {
	return addDay;
}

public void setAddDay(int addDay) {
	this.addDay = addDay;
}

public Staj() {
	addDay=1;
	stavka=0f;
}

public Staj(Staj s) {
	this.startDate = s.startDate;
	this.endDate = s.endDate;
	this.period = s.period;
	this.cggext = s.cggext;
	this.cwcext = s.cwcext;
	this.ctpext = s.ctpext;
	this.dopctpext = s.dopctpext;
	this.cspext = s.cspext;
	this.dopcspext = s.dopcspext;
	this.vidDeyat = s.vidDeyat;
	this.addDay=1;
	this.stavka=0f;
	this.predprName=s.predprName;
	this.flag=s.flag;
	this.regNumb=s.regNumb;
}

public static Staj makeCopy(Staj s) {
	Staj s1=new Staj(s);
	s1.setStavka(s.getStavka());
	return s1;
}




public String getVidDeyat() {
	return vidDeyat;
}

public void setVidDeyat(String vidDeyat) {
	this.vidDeyat = vidDeyat==null?"":vidDeyat.trim();
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
	this.cggext = cggext!=null?cggext.trim():"";
}

public String getCwcext() {
	return cwcext;
}

public void setCwcext(String cwcext) {
	this.cwcext = cwcext!=null?cwcext.trim():"";
}

public String getCtpext() {
	return ctpext;
}

public void setCtpext(String ctpext) {
	this.ctpext = ctpext!=null?ctpext.trim():"";
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
	this.cspext = cspext!=null?cspext.trim():"";
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
