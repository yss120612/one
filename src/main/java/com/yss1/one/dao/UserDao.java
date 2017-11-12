package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yss1.one.models.Role;
import com.yss1.one.models.User;

@Component
public class UserDao extends PostgressDao {
	@Autowired
	RoleDao roleDao;
	
	public User getUserByName(String name) {
		User u= pgDT.queryForObject("select id,username,password,enable,locked from public.users where username="+name,userRowMapper);
		if (u==null) return null;
		HashSet<Long> role_ids=new HashSet<Long>(pgDT.query("select id_role where id_user="+u.getId(),idRowMapper));
		HashSet<Role> roles=new HashSet<>();
		for (Long lx:role_ids)
		{
			roles.add(roleDao.findRoleById(lx));
		}
		u.setAuthorities(roles);
		return u;
	}
	
	private RowMapper<User> userRowMapper=new RowMapper<User>() {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEnabled(rs.getBoolean("enable"));
			user.setLocked(rs.getBoolean("locked"));
			return user;
			}};
			
	private RowMapper<Long> idRowMapper=new RowMapper<Long>() {
				public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
					Long l = new Long(rs.getLong("id_role"));
					return l;
					}};
					
}
