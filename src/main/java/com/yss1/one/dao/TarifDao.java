package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Vsnos;

@Repository
public class TarifDao {
	@Autowired
	private DataSource pgDS;
	
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
	JdbcTemplate pgDT=new JdbcTemplate(pgDS);
	if (lt==null)
	{
		lt=pgDT.query("select kod, year,strah2,strah3,nakop2,nakop3,gr_vznos from tarifs order by year,kod",tarifRowMapper);
	}
	for(Vsnos vs:lv) {
		if (vs.getCprcod()!=0)
		{
			for (Tarif t:lt)
			{
			if (vs.getCprcod()==t.getKod() && vs.getYear()==t.getYear())
			{
				vs.setStrah(before67?t.getStrah2():t.getStrah3());
				vs.setNacop(before67?t.getNacop2():t.getNacop3());
				break;
			}
			}
		}
	}
	
	
	}
	
	private RowMapper<Tarif> tarifRowMapper = new RowMapper<Tarif>() {
		public Tarif mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Tarif(rs.getInt("kod"),rs.getInt("year"),rs.getFloat("strah2"),rs.getFloat("strah3"),rs.getFloat("nakop2"),rs.getFloat("nakop3"),rs.getFloat("gr_vznos"));
		}
	};
	
	
	private class Tarif {
		private int kod;
		private int year;
		private float strah2;
		private float strah3;
		private float nacop2;
		private float nacop3;
		private float gr_vznos;
		public Tarif(int kod, int year, float strah2, float strah3, float nacop2, float nacop3, float gr_vznos) {
			this.kod = kod;
			this.year = year;
			this.strah2 = strah2;
			this.strah3 = strah3;
			this.nacop2 = nacop2;
			this.nacop3 = nacop3;
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
		public float getNacop2() {
			return nacop2;
		}
		public float getNacop3() {
			return nacop3;
		}
		public float getGr_vznos() {
			return gr_vznos;
		}
		

		
		
	}
}
