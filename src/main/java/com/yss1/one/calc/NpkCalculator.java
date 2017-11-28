package com.yss1.one.calc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.UrDao;
//расчет начального пенсионного капитала
@Service
public class NpkCalculator {
	@Autowired
	UrDao urDao;
	
	public float calc(float rpk, float kval, Date dp)
	{
		float result=rpk*(1+kval);
		result=urDao.indexSumm(dp, result);
		return result;
	}
	
}
