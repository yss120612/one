package com.yss1.one.util;
//модель для хранения любого периода в формате дни/месяцы/годы
//умеет себя складывать с другим и умножать на коэффициент
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

//прибавляет к текущему периоду другой	
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

//возвращает новый период в виде себя умноженного на коэффициент. текущий не изменяет
public Period multPeriod(float mult) {
return Utils.multPeriod(this, mult);	
}


private int years;
private int months;
private int days;
}
