package com.yss1.one.models;

import java.util.Date;

import com.yss1.one.util.Utils;

public class Vsnos {
	
//код района и региона
private int dptcod;
//входящий номер
private long dcinmb;
//год
private int year;
//отчетный период
private String ctmcod;
//сумма взноса
private float asr;
//код вида деятельности в строковом виде
private String cprext;
//код вида деятельности в числовом виде
private int cprcod;

//тарифы страховая часть 
private float strah;

//тарифы солидарная часть 
private float solid;

//дата окончания периода перечисленного взноса
private Date date;


public int getDptcod() {
	return dptcod;
}
public void setDptcod(int dptcod) {
	this.dptcod = dptcod;
}
public long getDcinmb() {
	return dcinmb;
}
public void setDcinmb(long dcinmb) {
	this.dcinmb = dcinmb;
}
public String getCtmcod() {
	return ctmcod;
}
public void setCtmcod(String ctmcod) {
	this.ctmcod = ctmcod;
	year=Integer.parseInt(ctmcod.substring(0,4));
	int p=-1;
	if(ctmcod.length()>5)
	{
		p=Integer.parseInt(ctmcod.substring(5,6));
	}
	
	if (year<=2014 && year>=2002)
	{
	if (year<2010)
	{
		date=Utils.makeDate(year, 12, 31);
	}
	else if (year==2010)
	{
		if (p==0 || p==2) {
			date=Utils.makeDate(2010, 12, 31);
		}else if (p==1)
		{
			date=Utils.makeDate(2010, 6, 30);
		}
			
	}
	else
	{
		if (p==0 || p==4) {
			date=Utils.makeDate(year, 12, 31);
		}
		else if (p==1)
		{
			date=Utils.makeDate(year, 3, 31);
		}
		else if (p==2)
		{
			date=Utils.makeDate(year, 6, 30);
		}
		else if (p==3)
		{
			date=Utils.makeDate(year, 9, 30);
		}
	}
	}
}
public float getAsr() {
	return asr;
}
public void setAsr(float asr) {
	this.asr = asr;
}
public String getCprext() {
	return cprext;
}
public void setCprext(String cprext) {
	this.cprext = cprext;
}
public int getCprcod() {
	return cprcod;
}
public void setCprcod(int cprcod) {
	this.cprcod = cprcod;
}
public float getStrah() {
	return strah;
}
public void setStrah(float strah) {
	this.strah = strah;
}
public float getSolid() {
	return solid;
}
public void setSolid(float solid) {
	this.solid = solid;
}
public Date getDate() {
	return date;
}
public int getYear() {
	return year;
}
@Override
public String toString() {
	return "Vsnos [dptcod=" + dptcod + ", year=" + year + ", ctmcod=" + ctmcod + ", asr=" + asr
			+ ", cprext=" + cprext + ", cprcod=" + cprcod + ", strah=" + strah + ", solidar=" + solid +", datev=" + Utils.getFormattedDate(date)+ "]";
}


}
