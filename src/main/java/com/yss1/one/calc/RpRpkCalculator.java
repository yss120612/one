package com.yss1.one.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.DojityeDao;

//калькулятор расчетной пенсии и расчетного пенсионного капиталла
@Service
public class RpRpkCalculator {
@Autowired	
DojityeDao dojDao;

//на вход стажевый коэффициент и зарплатное отношение
	public float CalcRp(float sk, float sratio)
	{
		float res=1671f*sk*sratio;
		return res<660?660:res;
	}
	
	//на вход понижающий стажевый коэффициент, расчетную пенсию, год права и лготный стаж  
	public float CalcRpk(float psk, float rp, int yp, boolean lgota)
	{
		return (rp-450)*psk*dojDao.getPeriod(yp,lgota);
	}
	
}
