package com.yss1.one.models;

import java.util.ArrayList;
import java.util.List;

import com.yss1.one.util.Period;
import com.yss1.one.util.Twix;

public class LgStaj {

	
private String name;

private Period period;

private int month;

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
}



}
