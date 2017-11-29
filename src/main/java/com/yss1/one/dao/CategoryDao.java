package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Vsnos;
import com.yss1.one.util.Utils;

@Repository
public class CategoryDao {
	@Autowired
	private JdbcTemplate pgDT;
	// меняем код взноса с буквенного на цифровой
	public void setCode(Vsnos vsnos) {
		String myd = Utils.getFormattedDate4sql2(Utils.makeDate(vsnos.getYear(), 1, 2));
		String now = Utils.getFormattedDate4sql2(new Date());

//		Integer kod = null;
//		Integer count = pgDT.queryForObject("select count(*) from public.category where category='?' and Date('?') between dstart and COALESCE(dend,Date('?'))"
//				, Integer.class, vsnos.getCprext().trim(),myd,now);
//		if (count > 0) {
//		           	  kod = pgDT.queryForObject("select code from public.category where category='?' and Date('?') between dstart and COALESCE(dend,Date('?'))"
//					, Integer.class, vsnos.getCprext().trim(),myd,now);
//		}

		List<Integer> lk=pgDT.query("select code from public.category where category='"+vsnos.getCprext().trim()+"' and Date('"+myd+"') between dstart and COALESCE(dend,Date('"+now+"'))",intRowMapper);
		
		//System.out.println("Kode="+kod);
		if (lk==null || lk.isEmpty()) {
			vsnos.setCprcod(0);
			return;
		} else {
			vsnos.setCprcod(lk.get(0));
		}
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
	private RowMapper<Integer> intRowMapper = new RowMapper<Integer>() {
		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Integer(rs.getInt(1));
		}
	};

}
