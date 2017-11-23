package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yss1.one.models.Role;

@Repository
public class RoleDao {

	@Autowired
	private JdbcTemplate pgDT;

	
//	@Autowired
//	private ApplicationContext ctx;
//	@PostConstruct
//	private void init() {
//		pgDT = (JdbcTemplate) ctx.getBean("postgressJdbcTemplate");
//	}

	public Role findRoleById(Long id) {
		Role n = pgDT.queryForObject("select id,rolename from public.roles where id=" + id.toString(), nameRowMapper);
		return n;
	}

	public Role findRoleByName(String name) {
		Role n = null;
		try
		{
			n = pgDT.queryForObject("select id,rolename from public.roles where rolename='" + name.trim().toUpperCase() + "'", nameRowMapper);
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
		return deleteRole(r);
	}

	public boolean deleteRole(String name) {
		Role r = findRoleByName(name);
		return deleteRole(r);
		
	}

	private boolean deleteRole(Role r) {
		if (r == null)
			return false;
		long id = r.getId();
		pgDT.update("delete from public.users_roles where id_role=?", id);
		pgDT.update("delete from public.roles where id=?", id);
		return true;
	}
	
	
	public Role addRole(String name) {
		if (!checkExist(name)) {
			pgDT.update("insert into public.roles (rolename) values(?)", name.trim().toUpperCase());	
		}
		return findRoleByName(name);
	}

	public boolean editRole(Role r, String newName) {
		if (checkExist(newName)) {
			return false;
		}
		pgDT.update("update public.roles set rolename=? where id=?", newName.trim().toUpperCase(), r.getId());
		return true;
	}

	public boolean checkExist(String name) {
		int l = pgDT.queryForObject("select count(*) from public.roles where rolename='" + name.trim().toUpperCase() + "'", Integer.class);
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
