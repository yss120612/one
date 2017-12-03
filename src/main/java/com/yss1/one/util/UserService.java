package com.yss1.one.util;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yss1.one.dao.RoleDao;
import com.yss1.one.dao.UserDao;
import com.yss1.one.models.Role;
import com.yss1.one.models.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	@PostConstruct
	public void init() {
		//Если никого нет делаем юзера с 2я ролями
		if (userDao.getAllUsers().isEmpty()) {
			User u =userDao.addUser("user", "1111",true);
			Role r = roleDao.findRoleByName("ADMIN");
			if (r == null) {
				r = roleDao.addRole("ADMIN");
			}
			u.addRole(r);
			r = roleDao.findRoleByName("USER");
			if (r == null) {
				r = roleDao.addRole("USER");
			}
			u.addRole(r);
			userDao.saveUser(u);
		}
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserByName(username);
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword("1111");
		if (user == null) {
			throw new UsernameNotFoundException("Пользователь " + username + " не найден!");
		}
		return user;
	}

}
