package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.ResListItem;
import com.yss1.one.util.Utils;
import com.yss1.one.util.WebUtils;

@Repository
public class SpravkaDao {
	@Autowired
	private DataSource pgDS;
	
	private JdbcTemplate pgDT;
	
	@PostConstruct
	public void init() {
		pgDT=new JdbcTemplate(pgDS);
	}
	
	public byte [] getRasch(long id) {
	
		int count=pgDT.queryForObject("select count(*) from public.spravka where id=? and raschet is not null ",Integer.class,id);
		if (count==0) return null;
		String str = new String(pgDT.queryForObject("select raschet from public.spravka where id=?",byte [].class,id));
		byte [] ba = Utils.hexStr2bytes(str);
		return ba;
	}
	
	public byte[] getRasyasn(long id) {
		
		int count=pgDT.queryForObject("select count(*) from public.spravka where id=? and szi_new is not null ",Integer.class,id);
		if (count==0) return null;
		String str = new String(pgDT.queryForObject("select szi_new from public.spravka where id=?",byte [].class,id));
		byte [] ba = Utils.hexStr2bytes(str);
		return ba;
	}
	
	public Long insertAndGetId(String dt,String snils) {
		pgDT.update("insert into public.spravka (vc_client,vc_ins,ts_q,pens) values ('"+ WebUtils.getLogin() + "','" + snils + "',TIMESTAMP '" + dt + "',0)");
		Long result=pgDT.queryForObject("select id from public.spravka where vc_client='"+WebUtils.getLogin()+"' and vc_ins='"+snils+"' and ts_q=TIMESTAMP '"+dt+"'", Long.class);
		return result;
	}
	
	//получаем список запросов
	public List<ResListItem> getResList(int daysAgo, String user){
		GregorianCalendar gc=new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(GregorianCalendar.DAY_OF_MONTH,-daysAgo);
		String now = Utils.getFormattedDate4sql(gc.getTime());
		int count=pgDT.queryForObject("select count(*) from public.spravka where vc_client='"+user+"' and ts_a>TIMESTAMP '"+now+"'",Integer.class);
		if (count<1) return new ArrayList<ResListItem>(); 
		List<ResListItem> res=pgDT.query("select id,vc_client,vc_ins,fio,pravo,pens,ts_a from public.spravka where vc_client='"+user+"' and ts_a>TIMESTAMP '"+now+"' order by ts_a desc",itemRowMapper);
		
		return res;
	}
	
	
	private RowMapper<ResListItem> itemRowMapper = new RowMapper<ResListItem>() {
		public ResListItem mapRow(ResultSet rs, int rowNum) throws SQLException {
			ResListItem rli=new ResListItem();
			rli.setId(rs.getLong("id"));
			rli.setPravo(rs.getDate("pravo"));
			rli.setPensya(rs.getFloat("pens"));
			rli.setFio(rs.getString("fio"));
			rli.setSnils(rs.getString("vc_ins"));
			rli.setUser(rs.getString("vc_client"));
			rli.setQueryDate(rs.getDate("ts_a"));
			return rli;
		}
	};
	
}
