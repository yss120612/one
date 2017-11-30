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
	
	public void setTarif(List<Vsnos> lv, boolean before67)
	{
	// идем за тарифами (процент, отчисляемый из ЗП)
	String sql="select kod, year, "+(before67?"strah2 ":"strah3 ");

	List<Tarif> lt=pgDT.query(sql+"from tarifs order by year,kod",tarifRowMapper);
	
	for(Vsnos vs:lv) {
		if (vs.getCprcod()!=0)
		{
			for (Tarif t:lt)
			{
			if (vs.getCprcod()==t.getKod() && vs.getYear()==t.getYear())
			{
				vs.setStrah(t.getTarif());
				break;
			}
			}
		}
	}
	
	
	}
	
	private RowMapper<Tarif> tarifRowMapper = new RowMapper<Tarif>() {
		public Tarif mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Tarif(rs.getInt("kod"),rs.getInt("year"),rs.getFloat(3));
		}
	};
	
	
	private class Tarif {
		
		private int kod;
		public Tarif(int kod, int year, float tarif) {
			this.kod = kod;
			this.year = year;
			this.tarif = tarif;
		}
		private int year;
		private float tarif;
		public int getKod() {
			return kod;
		}
		public void setKod(int kod) {
			this.kod = kod;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public float getTarif() {
			return tarif;
		}
		public void setTarif(float tarif) {
			this.tarif = tarif;
		}
		
		
	}
}
