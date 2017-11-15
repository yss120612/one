package com.yss1.one.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.yss1.one.models.Role;
import com.yss1.one.models.User;

@Component
public class UserDao {
	@Autowired
	RoleDao roleDao;

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private PasswordEncoder bpe;

	private JdbcTemplate pgDT;

	@PostConstruct
	private void init() {
		pgDT = (JdbcTemplate) ctx.getBean("postgressJdbcTemplate");
	}

	private void fillRoles(User us) {
		List<Long> rl = pgDT.query("select id_role from public.users_roles where id_user=" + us.getId(), idRowMapper);
		HashSet<Long> role_ids = (rl == null) ? new HashSet<Long>() : new HashSet<Long>(rl);
		HashSet<Role> roles = new HashSet<>();
		for (Long lx : role_ids) {
			roles.add(roleDao.findRoleById(lx));
		}
		us.setAuthorities(roles);
	}

	public User getUserByName(String name) {
		User u = null;
		try {
			u = pgDT.queryForObject("select id,username,password,enable,locked from public.users where username='" + name + "'",userRowMapper);
		} catch (Exception ex) {

		}
		if (u == null)
			return null;
		fillRoles(u);
		return u;
	}

	public User getUserById(long id) {
		User u = pgDT.queryForObject("select id,username,password,enable,locked from public.users where id=" + id,
				userRowMapper);
		if (u == null)
			return null;
		fillRoles(u);
		return u;
	}

	public User addUser(String name, String pass) {
		pgDT.update("insert into public.users (username,password,enable,locked) values(?,?,true,false)", name,
				bpe.encode(pass));
		return getUserByName(name);
	}

	public boolean saveUser(User u) {// если что то поменяли в ЮИ пишем в базу
		User u0 = getUserById(u.getId());
		if (u0 == null) {
			return false;
		}

		if (u0.isEnabled() != u.isEnabled() || u0.isAccountNonLocked() != u.isAccountNonLocked()) {// были поменяны
																									// флаги
			pgDT.update("update public.users set enable=?,locked=? where id=?", u.isEnabled(), u.isAccountNonLocked(),
					u.getId());
		}
		// update roles
		if (u.getAuthorities().size() == u0.getAuthorities().size()
				&& u.getAuthorities().containsAll(u0.getAuthorities())) {
			return true;// роли не трогали
		}

		pgDT.update("delete from public.users_roles id_user=?", u.getId());
		for (Role r : (HashSet<Role>) u.getAuthorities()) {
			pgDT.update("insert into public.users_roles (id_user, id_role) values(?,?)", u.getId(), r.getId());
		}
		return true;
	}

	public boolean deleteUser(long idx) {
		User u0 = getUserById(idx);
		if (u0 == null) {
			return false;
		}
		pgDT.update("delete public.users where id=?", idx);
		pgDT.update("delete from public.users_roles id_user=?", idx);
		return true;
	}

	public boolean deleteUser(String name) {
		User u0 = getUserByName(name);
		if (u0 == null) {
			return false;
		}
		long idx = u0.getId();
		pgDT.update("delete public.users where id=?", idx);
		pgDT.update("delete from public.users_roles id_user=?", idx);
		return true;
	}

	private RowMapper<User> userRowMapper = new RowMapper<User>() {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEnabled(rs.getBoolean("enable"));
			user.setLocked(rs.getBoolean("locked"));
			return user;
		}
	};

	private RowMapper<Long> idRowMapper = new RowMapper<Long>() {
		public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
			Long l = new Long(rs.getLong("id_role"));
			return l;
		}
	};

}
