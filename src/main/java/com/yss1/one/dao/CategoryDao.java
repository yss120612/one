package com.yss1.one.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Vsnos;
import com.yss1.one.util.Utils;

@Repository
public class CategoryDao {
	@Autowired
	private JdbcTemplate pgDT;

	public void setTarifs(Vsnos vsnos, boolean before67) {
		String myd = Utils.getFormattedDate4sql2(Utils.makeDate(vsnos.getYear(), 1, 2));
		String now = Utils.getFormattedDate4sql2(new Date());
		// меняем код взноса с буквенного на цифровой
		Integer kod = null;
		Integer count = pgDT.queryForObject("select count(*) from public.category where category='?' and Date('?') between dstart and COALESCE(dend,Date('?'))"
				, Integer.class, vsnos.getCprext().trim(),myd,now);
		if (count > 0) {
		           	  kod = pgDT.queryForObject("select code from public.category where category='?' and Date('?') between dstart and COALESCE(dend,Date('?'))"
					, Integer.class, vsnos.getCprext().trim(),myd,now);
		}

		//System.out.println("Kode="+kod);
		if (kod == null) {
			vsnos.setCprcod(0);
			return;
		} else {
			vsnos.setCprcod(kod);
		}

		// идем за тарифами
		String sql="select ";
		sql+=(before67?"strah2":"strah3");
		Float th = pgDT.queryForObject(sql+" from tarifs where kod=? and year=?",Float.class, vsnos.getCprcod(), vsnos.getYear());
		vsnos.setStrah(th);
	}

	// вспомогательный класс для тфрифов
//	private class TarifHelper {
//		private float strah2;
//		private float strah3;
//
//		public float getStrah2() {
//			return strah2;
//		}
//
//		public float getStrah3() {
//			return strah3;
//		}
//
//		public TarifHelper(float strah2, float strah3) {
//			this.strah2 = strah2;
//			this.strah3 = strah3;
//		}
//	}
//
//	private RowMapper<TarifHelper> tarifHelperRowMapper = new RowMapper<TarifHelper>() {
//		public TarifHelper mapRow(ResultSet rs, int rowNum) throws SQLException {
//			return new TarifHelper(rs.getFloat("strah2"), rs.getFloat("strah2"));
//		}
//	};

}
