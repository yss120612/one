package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.MaxIPKDao;
import com.yss1.one.dao.SPKDao;
import com.yss1.one.dao.TarifDao;
import com.yss1.one.models.Vsnos;
import com.yss1.one.util.Utils;

@Service
public class FinishCalculator {
@Autowired
private MaxIPKDao maxIPKDao;

@Autowired
private SPKDao spkDao;

@Autowired
private TarifDao tarifDao;


private List<vs15> vs15list;

public float calcPens(float f, Date time) {
	// TODO Auto-generated method stub
	return spkDao.getSpk(time)*f;
}

public float calcFix(Date time) {
	// TODO Auto-generated method stub
	return spkDao.getFixVipl(time);
}


public float calcIPK(List<Vsnos> lv, Date prav) {
	vs15list=new ArrayList<>();
	vs15 curr;
	for (Vsnos vs:lv)
	{
		if (vs.getYear()>=2015 && Utils.beforeOrEqual(vs.getDate(),prav)) {
			curr=getElement(vs.getYear());
			curr.setCode(vs.getCprcod());
			curr.summ+=vs.getAsrItog();
		}
	}
	float summa=0;
	float cs;
	for (vs15 v: vs15list) {
		v.setMaxSumm(tarifDao.getGrVsnos(v.getYear(),v.getCode())*0.16f);
		v.setIpks(maxIPKDao.getIpks(v.getYear()));
		v.setIpkn(maxIPKDao.getIpkn(v.getYear()));
		//if (v.getSumm()>v.getMaxSumm()) v.setSumm(v.getMaxSumm());
		cs=v.getSumm()/v.getMaxSumm()*10;
		summa+=cs>v.getIpks()?v.getIpks():cs;
	}

	
	return summa;
}

private vs15 getElement(int ye) {
	for (vs15 v: vs15list) {
		if (v.getYear()==ye) {
			return v;
		}
	}
	vs15 vs=new vs15();
	vs.setYear(ye);
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
