package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yss1.one.models.Role;
import com.yss1.one.models.User;

@Component
public class UserDao {
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	private ApplicationContext ctx;
	
	private JdbcTemplate pgDT;
	@PostConstruct
	private void init() {
		pgDT=(JdbcTemplate)ctx.getBean("postgressJdbcTemplate");
	}
	
	
	private void fillRoles(User us)
	{
		HashSet<Long> role_ids=new HashSet<Long>(pgDT.query("select id_role where id_user="+us.getId(),idRowMapper));
		HashSet<Role> roles=new HashSet<>();
		for (Long lx:role_ids)
		{
			roles.add(roleDao.findRoleById(lx));
		}
		us.setAuthorities(roles);
	}
	
	public User getUserByName(String name) {
		User u= pgDT.queryForObject("select id,username,password,enable,locked from public.users where username="+name,userRowMapper);
		if (u==null) return null;
		fillRoles(u);
		return u;
	}
	
	public User getUserById(long id)
	{
		User u= pgDT.queryForObject("select id,username,password,enable,locked from public.users where id="+id,userRowMapper);
		if (u==null) return null;
		fillRoles(u);
		return u;
	}
	
	public void addUser(String name,String pass)
	{
		pgDT.update("insert into public.users (username,password,enable,locked) values(?,?,true,false)", name,pass);
	}
	
	//public boolean addRoles()
	
//	public void add role
//	public void removeUser(long id)
//	{
//		int cnt=pgDT.queryForObject("select count(*) from public.users where id="+id,
//	}
//	
//	public void createDeveloper(String name, String specialty, Integer experience);
//
//    public Developer getDeveloperById(Integer id);
//
//    public List listDevelopers();
//public void updateDeveloper(Inte
	
	
	
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
