package com.yss1.one.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.DojityeDao;
//расчет индивидуального пенсионного капиталла на 1 января 2015 года
@Service
public class Ipk15Calculator {
	@Autowired	
	DojityeDao dojDao;
	public float calc(float npk, float vsnosy, int ydp, boolean lgota)
	{
		int doj=dojDao.getPeriod(ydp, lgota);
		return (npk+vsnosy)/doj/64.1f;
	}
}
