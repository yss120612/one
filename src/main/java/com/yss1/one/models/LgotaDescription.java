package com.yss1.one.models;

import java.util.ArrayList;

import java.util.List;

import com.yss1.one.util.Twix;

//Льгота с правилами применения
public class LgotaDescription {
public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
//наименование льготы в выборке	
private String fullName;	
//наименование льготы в выборке	
private String name;
//поле в выборке, в котором льгота проставляется
private String field;
private float man_os;//общий стаж мужчин
private float woman_os;//общий стаж женщин
private float man_ss;//спец стаж мужчин
private float woman_ss;//спец стаж женщин
private float man_pens;//возраст права для мужчин
private float woman_pens;//возраст права для женщин
//можно ли выработать не полный спецстаж и сколько (делитель)
private float half;

//с чем суммируется и с каким коэффициентом
private List<Twix<String,Float>> forSumm;


//сколько месяцев неполного стажа
private float man_d;
//на сколько месяцев приближают пенсию
private float man_ds;
private float woman_d;
private float woman_ds;

//как две следующие льготы влияют на данную (множитель)
private float lepro;
private float sever;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name.trim();
}
public String getField() {
	return field;
}
public void setField(String field) {
	this.field = field.trim();
}
public float getMan_os() {
	return man_os;
}
public void setMan_os(float man_os) {
	this.man_os = man_os;
}
public float getWoman_os() {
	return woman_os;
}
public void setWoman_os(float woman_os) {
	this.woman_os = woman_os;
}
public float getMan_ss() {
	return man_ss;
}
public void setMan_ss(float man_ss) {
	this.man_ss = man_ss;
}
public float getWoman_ss() {
	return woman_ss;
}
public void setWoman_ss(float woman_ss) {
	this.woman_ss = woman_ss;
}
public float getMan_pens() {
	return man_pens;
}
public void setMan_pens(float man_pens) {
	this.man_pens = man_pens;
}
public float getWoman_pens() {
	return woman_pens;
}
public void setWoman_pens(float woman_pens) {
	this.woman_pens = woman_pens;
}
public float getHalf() {
	return half;
}
public void setHalf(float half) {
	this.half = half;
}
public float getMan_d() {
	return man_d;
}
public void setMan_d(float man_d) {
	this.man_d = man_d;
}
public float getMan_ds() {
	return man_ds;
}
public void setMan_ds(float man_ds) {
	this.man_ds = man_ds;
}
public float getWoman_d() {
	return woman_d;
}
public void setWoman_d(float woman_d) {
	this.woman_d = woman_d;
}
public float getWoman_ds() {
	return woman_ds;
}
public void setWoman_ds(float woman_ds) {
	this.woman_ds = woman_ds;
}
public float getLepro() {
	return lepro;
}
public void setLepro(float lepro) {
	this.lepro = lepro;
}
public float getSever() {
	return sever;
}
public void setSever(float sever) {
	this.sever = sever;
}

}
