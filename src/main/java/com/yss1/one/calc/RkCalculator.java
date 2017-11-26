package com.yss1.one.calc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.RkDao;
import com.yss1.one.models.Platej;
import com.yss1.one.util.Utils;
//калькулятор районного коэффициента
@Service
public class RkCalculator {

	@Autowired
	RkDao rkDao;
	
	public float calc(List<Platej> lpl)
	{
		Date tm=Utils.makeDate(1999, 12, 31);
		for (Platej pl: lpl) {
			if (pl.getdEnd().after(tm)) tm=pl.getdEnd();
		}
		List<Platej> lp=new ArrayList<>();
		for (Platej pl: lpl) {
			if (Utils.afterOrEqual(pl.getdEnd(),tm)) lp.add(pl);
		}
		System.out.println(lp.get(0));
		return rkDao.getRK(lp);
	}
}
