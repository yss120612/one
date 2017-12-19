package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.util.Utils;

//Взаимодействие со справочником условия расчета
@Repository
public class UrDao {
	@Autowired
	private DataSource pgDS;

	//перемножаем все козффициенты ранее даты права на заданную суммы
	public float indexSumm(Date dp, float summ) {
		
		JdbcTemplate pgDT=new JdbcTemplate(pgDS);
		String sql = "select datev,k_strah,k_str from public.ur where datev<date(?) order by datev";
		List<Koeff> lf=pgDT.query(sql,koeffRowMapper, Utils.getFormattedDate4sql2(dp));
		List<Float> tmp=new ArrayList<Float>(); 
		for (Koeff le: lf)
		{
			summ*=le.s;
			if (le.s>1.001)
			{
				tmp.clear();
			}
			else
			{
				tmp.add(le.s0);
			}
		}
		for(float k:tmp )
		{
			summ*=k;
		}
		return summ;
	}
	
	private RowMapper<Koeff> koeffRowMapper = new RowMapper<Koeff>() {
		public Koeff mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Koeff(rs.getDate("datev"),rs.getFloat("k_strah"),rs.getFloat("k_str"));
		}
	};
	
	private class Koeff
	{
		private Date dt;
		private float s0;
		private float s;
		public Date getDt() {
			return dt;
		}
		public float getS0() {
			return s0;
		}
		public float getS() {
			return s;
		}
		public Koeff(Date dt, float s0, float s) {
			this.dt = dt;
			this.s0 = s0;
			this.s = s;
		}
		
	}
}
