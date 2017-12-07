package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Vsnos;
import com.yss1.one.util.Twix;

@Repository
public class SolidarDao {

	@Autowired
	private JdbcTemplate pgDT;

	public void setSolidar(List<Vsnos> vl, boolean before67) {
		String sql;
		if (before67) {
			sql = "select  period,sld66 from public.solidar order by period";
		} else {
			sql = "select  period,sld67 from public.solidar order by period";
		}

		Map<String, Float> map = new HashMap<>();
		for (Twix<String, Float> tw : pgDT.query(sql, solidRowMapper)) {
			map.put(tw.getKey(), tw.getVal());
		}

		
		for (Vsnos vs: vl){
			if (vs.getYear()>=2002 && map.containsKey(vs.getCtmcod()))
			{
						vs.setSolid(map.get(vs.getCtmcod()));
						vs.setSolid(vs.getSolid()==0?0:vs.getStrah()+vs.getNacop()-16);
				}
			}
		
		
		
		
	}

	private RowMapper<Twix<String, Float>> solidRowMapper = new RowMapper<Twix<String, Float>>() {
		public Twix<String, Float> mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Twix<String, Float>(rs.getString("period"), rs.getFloat(2));
		}
	};

}
