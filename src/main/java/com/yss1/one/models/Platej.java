package com.yss1.one.models;

import java.util.Date;

import com.yss1.one.util.Utils;

public class Platej {
private Date dStart;
private Date dEnd;
private int raion;
private int region;
private float summa;
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
public int getRaion() {
	return raion;
}
public void setRaion(int raion) {
	this.raion = raion;
}
public int getRegion() {
	return region;
}
public void setRegion(int region) {
	this.region = region;
}
public float getSumma() {
	return summa;
}
public void setSumma(float summa) {
	this.summa = summa;
}
@Override
public String toString() {
	return "Platej [dStart=" + Utils.getFormattedDate(dStart) + ", dEnd=" + Utils.getFormattedDate(dEnd) + ", raion=" + raion + ", region=" + region + ", summa="
			+ summa + "]";
}

}
