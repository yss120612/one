package com.yss1.one.util;

public class Period {
public Period(int years, int months, int days) {
		this.years = years;
		this.months = months;
		this.days = days;
	}
@Override
public String toString() {
	return "{" + years + " / " + months + " / " + days + "}";
}
public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
public void addPeriod(Period p)
{
	if (p==null) {
		
		return;
	}
	this.years+=p.getYears();
	this.months+=p.getMonths();
	this.days+=p.getDays();
	
	years=years+(months+days/30)/12;
	months=(months+days/30)%12;
	days=days%30;
}
private int years;
private int months;
private int days;
}
