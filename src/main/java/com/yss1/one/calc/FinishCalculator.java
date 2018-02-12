package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.MaxIPKDao;
import com.yss1.one.dao.MinUslDao;
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

@Autowired
private MinUslDao minUslDao;


private List<vs15> vs15list;

public float calcPens(float f, Date time) {
	// TODO Auto-generated method stub
	return spkDao.getSpk(time)*f;
}

public float getSpk(Date time) {
	return spkDao.getSpk(time);
}


public float calcFix(Date time, int koeffFix, int ijdevency) {
	float fv=spkDao.getFixVipl(time);
	if (koeffFix==0 && ijdevency==0) return fv;
	float fv3=(float)Math.rint(fv*100f/3f)/100f;

	if (ijdevency==1) fv=fv+fv3;
	else if (ijdevency==2) fv=fv+2*fv3;
	else if (ijdevency==3) fv=fv+3*fv3;
	
	if (koeffFix==1) fv*=1.3f;
	else if (koeffFix==2) fv*=1.5f;
	fv=(float)Math.rint(fv*100f)/100f;
	
	return fv;
}

public float getMinBall(int dpYear) {
	return minUslDao.getMinBall(dpYear);
}

public int getMinYear(int dpYear) {
	return minUslDao.getMinYear(dpYear);
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
		cs=v.getMaxSumm()==0?0:v.getSumm()/v.getMaxSumm()*10;
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
