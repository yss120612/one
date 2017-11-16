package com.yss1.one.util;

public class Period {
public Period(int years, int months, int days) {
		this.years = years;
		this.months = months;
		this.days = days;
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
private int years;
private int months;
private int days;
}
