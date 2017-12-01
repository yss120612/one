package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.yss1.one.util.Utils;

@Repository
public class SPKDao {
	@Autowired
	private JdbcTemplate pgDT;
	private List<SPKHelper> spkhl;
	public float getSpk(Date prav)
	{
		float res=-1f;
		float minSpk=-0.5f;
		if (spkhl==null) {
			fillList();
		}
		
		if (spkhl==null || spkhl.isEmpty()) return res;
		Date d1=spkhl.get(0).getDprava();
		for (SPKHelper h:spkhl)
		{
			if (minSpk<0 && h.getSpk()>0.5f) minSpk=h.getSpk();//выбрали минимальный СПК отличный от 0
			if (Utils.between(prav, d1, h.getDprava())) {
				res=h.getSpk();
				break;
			}
			else
			{
				d1=h.getDprava();
			}
			
		}
		
		if (res<-0.5f)//период не найден
		{
			if (Utils.between(prav, d1, Utils.makeDate(2099,1,1))) {
			res=spkhl.get(spkhl.size()-1).getSpk();//последний
			}
			else {
				res=0;
			}
		}
		
		if (res<0.5f) res=minSpk;
		return res;
	}
	
	public float getFixVipl(Date prav)
	{
		float res=-1f;
		float minFv=-0.5f;
		if (spkhl==null) {
			fillList();
		}
		
		if (spkhl==null || spkhl.isEmpty()) return res;
		Date d1=spkhl.get(0).getDprava();
		for (SPKHelper h:spkhl)
		{
			if (minFv<0 && h.getFixvipl()>0.5f) minFv=h.getFixvipl();//выбрали минимальный ФВ отличный от 0
			if (Utils.between(prav, d1, h.getDprava())) {
				res=h.getFixvipl();
				break;
			}
			else
			{
				d1=h.getDprava();
			}
			
		}
		
		if (res<-0.5f)//период не найден
		{
			if (Utils.between(prav, d1, Utils.makeDate(2099,1,1))) {
			res=spkhl.get(spkhl.size()-1).getFixvipl();//последний
			}
			else {
				res=0;
			}
		}
		
		if (res<0.5f) res=minFv;
		return res;
	}
	
	private void fillList() {
		pgDT.query("select * from sprspk order by date", spkRowMapper);
	}
	
	private RowMapper<SPKHelper> spkRowMapper = new RowMapper<SPKHelper>() {
		public SPKHelper mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new SPKHelper(rs.getDate("date"), rs.getFloat("spk"), rs.getFloat("fv"));
		}
	};
	
	private class SPKHelper{
		private Date dprava;
		private float spk;
		private float fixvipl;
		public SPKHelper(Date dprava, float spk, float fixvipl) {
			super();
			this.dprava = dprava;
			this.spk = spk;
			this.fixvipl = fixvipl;
		}
		public Date getDprava() {
			return dprava;
		}
		public float getSpk() {
			return spk;
		}
		public float getFixvipl() {
			return fixvipl;
		}
		
	}
	
	
}
