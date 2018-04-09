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

//замена старых кодов на новые их аналоги
@Repository
public class UpdateLgtCodesDao {

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
			if (st.getCggext().contains("/")) st.setCggext(st.getCggext().substring(0,st.getCggext().indexOf("/")));	
			if (st.getCwcext().contains("/")) st.setCwcext(st.getCwcext().substring(0,st.getCwcext().indexOf("/")));
			if (st.getCspext().contains("/")) st.setCspext(st.getCspext().substring(0,st.getCspext().indexOf("/")));
			
			
			//if (st.getDopcspext().contains("(")) st.setDopcspext(st.getDopcspext().substring(st.getDopcspext().indexOf("(")+1,st.getDopcspext().length()));
			//if (st.getDopcspext().contains(")")) st.setDopcspext(st.getDopcspext().substring(0,st.getDopcspext().indexOf(")")));
			//st.setDopcspext(st.getDopcspext().replaceAll(",","."));
			//System.out.println("st.getDopcspext()="+st.getDopcspext());
			for (DictCode dc:dictCodes)
			{
			if (dc.getField().equals("cggext") && st.getCggext().equals(dc.getCold())) {st.setCggext(dc.getCnew());break;}
			if (dc.getField().equals("cwcext") && st.getCwcext().equals(dc.getCold())) {st.setCwcext(dc.getCnew());break;}
			if (dc.getField().equals("cspext") && st.getCspext().equals(dc.getCold())) {st.setCspext(dc.getCnew());break;}
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
