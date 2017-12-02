package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Vsnos;

@Repository
public class TarifDao {
	@Autowired
	private JdbcTemplate pgDT;
	
	List<Tarif> lt;
	
	public float getGrVsnos(int y, int code) {
		for (Tarif t:lt)
		{
		if (code==t.getKod() && y==t.getYear())
		{
			return t.getGr_vznos();
		}
		}
		return 0;
	}
	
	
	
	
	public void setTarif(List<Vsnos> lv, boolean before67)
	{
	// идем за тарифами (процент, отчисляемый из ЗП)
	if (lt==null)
	{
		//String sql="select kod, year, "+(before67?"strah2 ":"strah3 ");
		lt=pgDT.query("select kod, year,strah2,strah3,gr_vznos from tarifs order by year,kod",tarifRowMapper);
	}
	for(Vsnos vs:lv) {
		if (vs.getCprcod()!=0)
		{
			for (Tarif t:lt)
			{
			if (vs.getCprcod()==t.getKod() && vs.getYear()==t.getYear())
			{
				vs.setStrah(before67?t.getStrah2():t.getStrah3());
				break;
			}
			}
		}
	}
	
	
	}
	
	private RowMapper<Tarif> tarifRowMapper = new RowMapper<Tarif>() {
		public Tarif mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Tarif(rs.getInt("kod"),rs.getInt("year"),rs.getFloat("strah2"),rs.getFloat("strah3"),rs.getFloat("gr_vznos"));
		}
	};
	
	
	private class Tarif {
		private int kod;
		private int year;
		private float strah2;
		private float strah3;
		private float gr_vznos;
		public Tarif(int kod, int year, float strah2, float strah3, float gr_vznos) {
			this.kod = kod;
			this.year = year;
			this.strah2 = strah2;
			this.strah3 = strah3;
			this.gr_vznos = gr_vznos;
		}
		public int getKod() {
			return kod;
		}
		public int getYear() {
			return year;
		}
		public float getStrah2() {
			return strah2;
		}
		public float getStrah3() {
			return strah3;
		}
		public float getGr_vznos() {
			return gr_vznos;
		}
		

		
		
	}
}
