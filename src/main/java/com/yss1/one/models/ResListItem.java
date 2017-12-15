package com.yss1.one.models;

import java.util.Date;

import com.yss1.one.util.Utils;

//Модель для отображения списка истории запросов
public class ResListItem {
	
private long id;
private String fio;
private Date queryDate;
private float pensya;
private Date pravo;
private String snils;
private String user;


public String getSnils() {
	return snils;
}

public void setSnils(String snils) {
	this.snils = snils;
}

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFio() {
	return fio!=null?fio:"-";
}

public void setFio(String fio) {
	this.fio = fio;
}

public Date getQueryDate() {
	return queryDate;
}

public void setQueryDate(Date queryDate) {
	this.queryDate = queryDate;
}

public float getPensya() {
	return pensya;
}

public String getPensyaStr() {
	return String.format("%,.2f", pensya);
}

public void setPensya(float pensya) {
	this.pensya = pensya;
}

public Date getPravo() {
	return pravo;
}

public String getPravoStr() {
	return pravo!=null?Utils.getFormattedDate(pravo):"-";
}

public void setPravo(Date pravo) {
	this.pravo = pravo;
}

public ResListItem() {
	
	
}
	
}
