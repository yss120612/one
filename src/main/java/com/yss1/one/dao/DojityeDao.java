package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//Взаимодействие со справочником периодов дожития
@Repository
public class DojityeDao {
	@Autowired
	private JdbcTemplate pgDT;

	private MinMax minMax;
	//получение периода дожития по дате права и наличию отсутствию льгот
	public int getPeriod(int year, boolean lgot) {
		int count = pgDT.queryForObject("select count(*) from public.dojitye where year=?", Integer.class, year);

		String sql = "";
		if (lgot) {
			sql = "select period_lgot from public.dojitye where year=?";
		} else {
			sql = "select period from public.dojitye where year=?";
		}

		if (count < 1) {
			if (minMax==null) {
				minMax = pgDT.queryForObject("select min(year) as ymin, max(year) as ymax from public.dojitye",mmRowMapper);
			}
			year = year < minMax.getMin() ? minMax.getMin() : minMax.getMax();
		}
		
		return pgDT.queryForObject(sql, Integer.class, year);
	}

	private class MinMax {
		public int getMin() {
			return min;
		}

		public int getMax() {
			return max;
		}

		private int min;
		private int max;

		public MinMax(int mi, int ma) {
			min = mi;
			max = ma;
		}

	}

	private RowMapper<MinMax> mmRowMapper = new RowMapper<MinMax>() {
		public MinMax mapRow(ResultSet rs, int rowNum) throws SQLException {
			MinMax mm = new MinMax(rs.getInt("ymin"), rs.getInt("ymax"));
			return mm;
		}
	};

}
