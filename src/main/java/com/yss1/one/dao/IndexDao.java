package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Vsnos;
import com.yss1.one.util.Twix;
import com.yss1.one.util.Utils;
//индексирует взносы
@Repository
public class IndexDao {
	
	@Autowired
	private DataSource pgDS;
	
	public void indexVsnos(List<Vsnos> lv, Date pravo)
	{
		JdbcTemplate pgDT=new JdbcTemplate(pgDS);
		String sql="select year, koeff from kindex order by year";
		Map<Integer,Float> map=new HashMap<>();
		for (Twix<Integer,Float> tw:pgDT.query(sql, idxRowMapper))
		{
			map.put(tw.getFirst(), tw.getSecond());
		}
		
		GregorianCalendar gc=new GregorianCalendar();
		gc.setTime(pravo);
		int limit=Math.min(2015,gc.get(GregorianCalendar.YEAR));
		for (Vsnos vs: lv){
			if (vs.getYear()>=2002 && vs.getYear()<=2014 && Utils.beforeOrEqual(vs.getDate(), pravo))
			{
				for (int i=vs.getYear();i<limit;i++)
				{
					if (map.containsKey(i))
					{
						vs.setAsrItog(vs.getAsrItog()*map.get(i));
					}
				}
			}
		}
	}
	
	private RowMapper<Twix<Integer,Float>> idxRowMapper = new RowMapper<Twix<Integer,Float>>() {
		public Twix<Integer,Float> mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Twix<Integer,Float>(rs.getInt("year"),rs.getFloat("koeff"));
		}
	};
}
