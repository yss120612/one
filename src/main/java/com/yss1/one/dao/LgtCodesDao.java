package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Staj;


@Repository
public class LgtCodesDao {

	@Autowired
	private DataSource pgDS;
	
	private List<DictCode> dictCodes;
	
	private void fillDict()
	{
		JdbcTemplate pgDT=new JdbcTemplate(pgDS);
		dictCodes = pgDT.query("select * from lgotcodes order by old_code", dcRowMapper);
	}
	
	public void updateCodes(List<Staj> ls) {
		if (dictCodes==null) fillDict();
		if (ls==null) return;
		for (Staj st: ls) {

			for (DictCode dc:dictCodes)
			{
			if (st.getCggext()!=null && st.getCggext().contains("/")) st.setCggext(st.getCggext().substring(0,st.getCggext().indexOf("/")));	
			//if (st.getCwcext()!=null && st.getCwcext().contains("/")) st.setCwcext(st.getCwcext().substring(0,st.getCwcext().indexOf("/")));
			//if (st.getCspext()!=null && st.getCspext().contains("/")) st.setCspext(st.getCspext().substring(0,st.getCspext().indexOf("/")));
			
			if (dc.field.equals("cggext") && st.getCggext().contains(dc.getCold())) st.setCggext(dc.getCnew());
			if (dc.field.equals("cwcext") && st.getCwcext().contains(dc.getCold())) st.setCwcext(dc.getCnew());
			if (dc.field.equals("cspext") && st.getCspext().contains(dc.getCold())) st.setCspext(dc.getCnew());
			}
		}
	}
	
	
	private RowMapper<DictCode> dcRowMapper = new RowMapper<DictCode>() {
		public DictCode mapRow(ResultSet rs, int rowNum) throws SQLException {
			DictCode mm = new DictCode(rs.getString("old_code"),rs.getString("new_code"),rs.getString("field"));
			return mm;
		}
	};
	
	private class DictCode{
		private String cold;
		private String cnew;
		private String field;
		public String getCold() {
			return cold;
		}
		public String getCnew() {
			return cnew;
		}
		public String getField() {
			return field;
		}
		public DictCode(String cold, String cnew, String field) {
			this.cold = cold.trim();
			this.cnew = cnew.trim();
			this.field = field.trim();
		}
		
		
	}
}
