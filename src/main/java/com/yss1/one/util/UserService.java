package com.yss1.one.util;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.yss1.one.dao.UserDao;
import com.yss1.one.models.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@PostConstruct
	public void init() {
		if (userDao.getUserByName("user") == null)
		{
			userDao.addUser("user", "1111");
		}
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Пользователь " + username + " не найден!");
		}
		return user;
	}

}
