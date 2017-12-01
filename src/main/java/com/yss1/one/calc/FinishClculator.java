package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.yss1.one.dao.MaxIPKDao;
import com.yss1.one.dao.SPKDao;
import com.yss1.one.dao.TarifDao;
import com.yss1.one.models.Vsnos;

public class FinishClculator {
@Autowired
private MaxIPKDao maxIPKDao;

@Autowired
private SPKDao spkDao;

@Autowired
private TarifDao tarifDao;


private List<vs15> vs15list;

public float calcNPK(List<Vsnos> lv, Date prav) {
	vs15list=new ArrayList<>();
	vs15 curr;
	for (Vsnos vs:lv)
	{
		if (vs.getYear()>=2015) {
			curr=getElement(vs.getYear(),vs.getCprcod());
			curr.summ+=vs.getAsrItog();
		}
	}
	
	for (vs15 v: vs15list) {
		v.setMaxSumm(tarifDao.getGrVsnos(v.getYear(),v.getCode())*0.16f);
		v.setIpks(maxIPKDao.getIpks(v.getYear()));
		v.setIpkv(maxIPKDao.getIpkn(v.getYear()));
	}
}

private vs15 getElement(int ye,int co) {
	for (vs15 v: vs15list) {
		if (v.getYear()==ye && v.getCode()==co) {
			return v;
		}
	}
	vs15 vs=new vs15();
	vs.setYear(ye);
	vs.setCode(co);
	vs15list.add(vs);
	return vs;
}


private class vs15{
	private int year;
	private int code;
	private float summ;
	private float maxSumm;
	private float ipks;
	private float ipkn;

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getSumm() {
		return summ;
	}
	public void setSumm(float summ) {
		this.summ = summ;
	}
	public float getMaxSumm() {
		return maxSumm;
	}
	public void setMaxSumm(float maxSumm) {
		this.maxSumm = maxSumm;
	}
	public float getIpks() {
		return ipks;
	}
	public void setIpks(float ipks) {
		this.ipks = ipks;
	}
	public float getIpkn() {
		return ipkn;
	}
	public void setIpkn(float ipkn) {
		this.ipkn = ipkn;
	}
	
	
}


}
