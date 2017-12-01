package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.util.Twix;

//иниерфейс к справочнику максимальных индивидуальных пенсионных коэффициентов по годам
@Repository
public class MaxIPKDao {
	@Autowired
	private JdbcTemplate pgDT;

	private List<IPKHelper> ipkhl;

	public float getIpks(int year) {
		if (ipkhl == null) {
			fillList();
		}
		float res = 0;
		for (IPKHelper h : ipkhl) {
			if (h.getYear() == year) {
				res = h.getIpks();
				break;
			}
		}
		return res;
	}

	public float getIpkn(int year) {
		if (ipkhl == null) {
			fillList();
		}
		float res = 0;
		for (IPKHelper h : ipkhl) {
			if (h.getYear() == year) {
				res = h.getIpkn();
				break;
			}
		}
		return res;
	}

	private void fillList() {
		ipkhl = pgDT.query("select * from spripk order by year", ipkRowMapper);
	}

	private class IPKHelper {
		private int year;
		private float ipks;
		float ipkn;

		public IPKHelper(int year, float ipks, float ipkn) {
			this.year = year;
			this.ipks = ipks;
			this.ipkn = ipkn;
		}

		public int getYear() {
			return year;
		}

		public float getIpks() {
			return ipks;
		}

		public float getIpkn() {
			return ipkn;
		}

	}

	private RowMapper<IPKHelper> ipkRowMapper = new RowMapper<IPKHelper>() {
		public IPKHelper mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new IPKHelper(rs.getInt("year"), rs.getFloat("ipks"), rs.getFloat("ipkn"));
		}
	};

}
