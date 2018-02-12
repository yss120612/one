package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class MinUslDao {
	@Autowired
	private DataSource pgDS;
	
	private List<MinUslHelper> minUslData;
	
	private void fillData() {
		JdbcTemplate pgDT=new JdbcTemplate(pgDS);
		minUslData=pgDT.query("select * from min_usl order by nyear", minUsRowMapper);	
	}
	
	
	public int getMinYear(int dpYear) {
		if (dpYear>2025) dpYear=2025;
		if (dpYear<2015) dpYear=2015;
		if (minUslData==null) {
		fillData();	
		}
		for (MinUslHelper muh:minUslData) {
			if (dpYear==muh.getYdprava()) {
				return muh.getMinYear();
			}
		}
		return 0;
	}
	
	public float getMinBall(int dpYear) {
		if (dpYear>2025) dpYear=2025;
		if (dpYear<2015) dpYear=2015;
		if (minUslData==null) {
		fillData();	
		}
		for (MinUslHelper muh:minUslData) {
			if (dpYear==muh.getYdprava()){
				return muh.getMinBall();
			}
		}
		return 0;
	}
	
	
	private RowMapper<MinUslHelper> minUsRowMapper = new RowMapper<MinUslHelper>() {
		public MinUslHelper mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new MinUslHelper(rs.getInt("nyear"), rs.getInt("stag"), rs.getFloat("ipk"));
		}
	};
	
	private class MinUslHelper{
		private int ydprava;
		private int minYear;
		private float minBall;
		public MinUslHelper(int dprava, int minYear, float minBall) {
			this.ydprava = dprava;
			this.minYear = minYear;
			this.minBall = minBall;
		}
		public int getYdprava() {
			return ydprava;
		}
		public int getMinYear() {
			return minYear;
		}
		public float getMinBall() {
			return minBall;
		}
		
		
	}
	
}
