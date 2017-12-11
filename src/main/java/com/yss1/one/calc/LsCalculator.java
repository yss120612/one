package com.yss1.one.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.LgotaDao;
import com.yss1.one.models.Lgota;
import com.yss1.one.util.Period;

@Service
public class LsCalculator {
@Autowired
LgotaDao lDao;
@Autowired
StajCalculator stCalc;

public Period calcLS(String ls) {
	Lgota lg=lDao.getLgota(ls);
		
return new Period(0,0,0);	
}


}
