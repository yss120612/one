package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yss1.one.models.Role;


@Component
public class RoleDao  {
	
	@Autowired
	private ApplicationContext ctx;
	private JdbcTemplate pgDT;

	@PostConstruct
	private void init() {
		pgDT=(JdbcTemplate)ctx.getBean("postgressJdbcTemplate");
	}
	
	public Role findRoleById(Long id) {
		Role n=pgDT.queryForObject("select id,rolename from roles where id="+id.toString(), nameRowMapper);
		return n;
	}
	
	public void addRole(String name) {
		pgDT.update("insert into public.roles (rolename) values(?)", name);
	}
	
	public void editRole(String name) {
		pgDT.update("insert into public.roles (rolename) values(?)", name);
	}
	
	public boolean checkExist(String name)
	{
		int l=pgDT.queryForObject("select count(*) from public.roles where rolename='"+name+"'",Integer.class);
		return l>0;
	}
	
	private RowMapper<Role> nameRowMapper=new RowMapper<Role>() {
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role r = new Role();
			r.setRoleName(rs.getString("rolename"));
			r.setId(rs.getLong("id"));
			return r;
			}};
}
