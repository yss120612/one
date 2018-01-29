package com.yss1.one.calc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.DojityeDao;

//калькулятор расчетной пенсии, расчетного пенсионного капиталла, начального пенсионного капиталла на 1 января 2015 г.
@Service
public class UniversalCalculator {
@Autowired	
DojityeDao dojDao;

//на вход стажевый коэффициент и зарплатное отношение
//калькулятор расчетной пенсии
	public float rpCalc(float stajK, float sratio)
	{
		float res=1671f*stajK*sratio;
		return res<660?660:res;
	}
	
	//на вход понижающий стажевый коэффициент, расчетную пенсию, год права и лготный стаж
	//калькулятор расчетного пенсионного капиталла
	public float rpkCalc(float psk, float rp, int yp, boolean lgota)

	{
		return (rp-450)*psk*dojDao.getPeriod(yp,lgota);
	}
	
	//на вход начальный пенсионный капитал, взносы с 15 года, год права и лготный стаж
	//калькулятор начального пенсионного капиталла на 1 января 2015 г.
	public float npk15Calc(float npk, float vsnosy, int ydp, boolean lgota)
	{
		int doj=getDojytie(ydp, lgota);
		return (npk+vsnosy)/doj/64.1f;
	}

	public int getDojytie(int ydp, boolean lgota) {
		// TODO Auto-generated method stub
		int doj=dojDao.getPeriod(ydp, lgota);
		return doj;
	}
	
	
	
}
