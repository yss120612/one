package com.yss1.one.models;

//Льгота с правилами применения
public class Lgota {
//наименование льготы в выборке	
private String name;
//поле в выборке, в котором льгота проставляется
private String field;
private float man_os;//общий стаж мужчин
private float women_os;//общий стаж женщин
private float man_ss;//спец стаж мужчин
private float women_ss;//спец стаж женщин
private float man_pens;//возраст права для мужчин
private float women_pens;//возраст права для женщин
//можно ли выработать не полный спецстаж и сколько (делитель)
private float half;

//как две следующие льготы влияют на данную (множитель)
private float lepro;
private float sever;
}
