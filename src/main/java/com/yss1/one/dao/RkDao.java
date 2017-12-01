package com.yss1.one.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Platej;


@Repository
public class RkDao {
	@Autowired
	private JdbcTemplate pgDT;

	
	public float getRK(List<Platej> lpl) {
		int rgn;
		int cnt;
		float curr=0f,koeff=0f;
		for (Platej pl : lpl) {
			rgn=pl.getRegion()*1000+pl.getRaion();
			cnt=pgDT.queryForObject("select count(*) from k_raions where kodr=?",Integer.class,rgn);
			if (cnt>0) {
				curr=pgDT.queryForObject("select koef from k_raions where kodr=?",Float.class,rgn);
				if (curr>koeff) koeff=curr;
			}
		}
		
		return koeff;
	}
	
}
