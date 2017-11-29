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

@Service
public class VsnosCalculator {

	@Autowired
	IndexDao indexDao;

	@Autowired
	SolidarDao solidarDao;

	@Autowired
	TarifDao tarifDao;

	public float calc(List<Vsnos> lv, GregorianCalendar pravo, PerfMeter meter) {
		
		meter.start();
		boolean before67=pravo.get(GregorianCalendar.YEAR)<1967;
		tarifDao.setTarif(lv, before67);
		meter.measure("VsnosCalculator:tarifDao.setTarif");
		meter.start();
		solidarDao.setSolidar(lv, before67);
		for (Vsnos vs : lv) {
			if (vs.getYear() >= 2002 && vs.getYear() <= 2015) {
				vs.setAsrItog(vs.getAsr()/ vs.getStrah() * (vs.getStrah() - vs.getSolid()) );

			}
			indexDao.indexVsnos(lv, pravo.getTime());
		}
		meter.measure("VsnosCalculator:solidarDao.setSolidar");
		meter.start();
		float res=0;
		for (Vsnos vs : lv) {
			if (vs.getYear()>=2002 && vs.getYear()<=2014)
			res+=vs.getAsrItog();
		}
		meter.measure("VsnosCalculator:calc summ");
		return res;
	}

}
