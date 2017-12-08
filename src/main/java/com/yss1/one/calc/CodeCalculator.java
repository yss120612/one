package com.yss1.one.calc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.CategoryDao;
import com.yss1.one.models.Vsnos;
//калькулятор тарифа страховых взносов в зависимости от категории взносов 
@Service
public class CodeCalculator {
	@Autowired	
	CategoryDao categoryDao;
	public void calc(List<Vsnos> lv) {
			categoryDao.setCode(lv);
	}
	
	
}
