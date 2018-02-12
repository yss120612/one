package com.yss1.one.calc;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.IndexDao;
import com.yss1.one.dao.SolidarDao;
import com.yss1.one.dao.TarifDao;
import com.yss1.one.models.Vsnos;
import com.yss1.one.util.PerfMeter;
import com.yss1.one.util.Utils;

@Service
public class VsnosCalculator {

	@Autowired
	IndexDao indexDao;

	@Autowired
	SolidarDao solidarDao;

	@Autowired
	TarifDao tarifDao;

	
	//сумма взносов за 02-14 года
	public float calc(List<Vsnos> lv, GregorianCalendar bd, GregorianCalendar pravo, PerfMeter meter) {
		
		
		boolean before67=bd.get(GregorianCalendar.YEAR)<1967;
		tarifDao.setTarif(lv, before67);
		
		
		
		solidarDao.setSolidar(lv, before67);
		
		
		
		for (Vsnos vs : lv) {
			if (vs.getStrah()>0) {
				vs.setAsrItog(vs.getAsr() * (vs.getStrah() - vs.getSolid())/ vs.getStrah());
			}
			
		}
		
		
		
		indexDao.indexVsnos(lv, pravo.getTime());
		float res=0;
		
		
		
		for (Vsnos vs : lv) {
			if (vs.getYear() >= 2002 && vs.getYear() <= 2014 && Utils.beforeOrEqual(vs.getDate(), pravo.getTime())) {
					res+=vs.getAsrItog();
			}
		}
		
		return res;
	}

}
