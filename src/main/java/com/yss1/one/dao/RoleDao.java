package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yss1.one.models.Role;

@Component
public class RoleDao {

	@Autowired
	private ApplicationContext ctx;
	private JdbcTemplate pgDT;

	@PostConstruct
	private void init() {
		pgDT = (JdbcTemplate) ctx.getBean("postgressJdbcTemplate");
	}

	public Role findRoleById(Long id) {
		Role n = pgDT.queryForObject("select id,rolename from public.roles where id=" + id.toString(), nameRowMapper);
		return n;
	}

	public Role findRoleByName(String name) {
		Role n = null;
		try
		{
			System.out.println("ASK DB");
		n = pgDT.queryForObject("select id,rolename from public.roles where rolename='" + name + "'", nameRowMapper);
		if (n==null)
		{
			System.out.println("n is NULL");
		}

		}
		catch(Exception ex)
		{
			System.out.println("findRoleByName error:"+ex.getMessage());
		}
		return n;
	}

	public List<Role> getRoleList() {
		return pgDT.query("select id,rolename from public.roles order by id", nameRowMapper);
	}

	public boolean deleteRole(long id) {
		Role r = findRoleById(id);
		if (r == null)
			return false;
		pgDT.update("delete from public.roles where id=?", id);
		pgDT.update("delete from public.users_roles id_role=?", id);
		return true;
	}

	public boolean deleteRole(String name) {
		Role r = findRoleByName(name);
		if (r == null)
			return false;
		long id = r.getId();
		pgDT.update("delete from public.roles where id=?", id);
		pgDT.update("delete from public.users_roles id_role=?", id);
		return true;
	}

	public boolean addRole(String name) {
		if (checkExist(name)) {
			return false;
		}
		pgDT.update("insert into public.roles (rolename) values(?)", name);
		return true;
	}

	public boolean editRole(Role r, String name) {
		if (checkExist(name)) {
			return false;
		}
		pgDT.update("update public.roles set rolename=? where id=?", name, r.getId());
		return true;
	}

	public boolean checkExist(String name) {
		int l = pgDT.queryForObject("select count(*) from public.roles where rolename='" + name + "'", Integer.class);
		return l > 0;
	}

	private RowMapper<Role> nameRowMapper = new RowMapper<Role>() {
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role r = new Role();
			r.setRoleName(rs.getString("rolename"));
			r.setId(rs.getLong("id"));
			return r;
		}
	};
}
