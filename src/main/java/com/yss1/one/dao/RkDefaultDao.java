package com.yss1.one.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.User;

@Repository
public class RkDefaultDao {
	@Autowired
	private DataSource pgDS;
	
	@Autowired
	UserDao userDao;
	
	public String getDefaultFor(String me) {
		User usr=userDao.getUserByName(me);
		if (usr==null) return "0";
		JdbcTemplate pgDT;
		pgDT=new JdbcTemplate(pgDS);
		
		Integer myDef=pgDT.queryForObject("select count(*) from rk_dflt where id=?",new Object[] {usr.getId()},Integer.class);
		if (myDef==0) return "0";
		myDef=pgDT.queryForObject("select rk from rk_dflt where id=?",new Object[] {usr.getId()},Integer.class);
		return myDef.toString();
	}
	
	public void setDefaultFor(String me,String val) {
		User usr=userDao.getUserByName(me);
		if (usr==null) return;
		JdbcTemplate pgDT;
		pgDT=new JdbcTemplate(pgDS);
		
		Integer myDef=pgDT.queryForObject("select count(*) from rk_dflt where id=?",new Object[] {usr.getId()},Integer.class);
		String sql="";
		if (myDef==0) {
			sql="insert into rk_dflt (rk,id) values(?,?)";
		}
		else {
			sql="update rk_dflt set rk=? where id=?";
		}
		
		pgDT.update(sql, Short.parseShort(val), usr.getId());
	}
	
	
	
}
