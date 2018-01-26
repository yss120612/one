package com.yss1.one.models;

import com.yss1.one.util.Period;

public class LgStaj {

//льготная кодировка	
private String name;

//суммарный период
private Period period;

//абсолютный период без суммирования
private Period absPeriod;

//на сколько месяцев приближает пенсию
private int month;

//стаж получился из одной категории или в результате суммы
private boolean single;


public boolean isSingle() {
	return single;
}
public void setSingle(boolean single) {
	this.single = single;
}
@Override
public String toString() {
	return "LgStaj [name=" + name + ", period=" + period + ", month=" + month + "]";
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Period getPeriod() {
	return period;
}
public void setPeriod(Period period) {
	this.period = period;
}
public LgStaj(String name, Period period) {
	this.name = name;
	this.period = period;
	this.absPeriod=new Period(0,0,0);
}


public Period getAbsPeriod() {
	return absPeriod;
}

public void setAbsPeriod(Period aperiod) {
	this.absPeriod = aperiod;
}




}
