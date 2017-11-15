package com.yss1.one;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.yss1.one.dao.RoleDao;
import com.yss1.one.dao.UserDao;
import com.yss1.one.models.Role;
import com.yss1.one.models.User;
import com.yss1.one.util.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OneApplicationTests {
	@Autowired
	ApplicationContext ctx;
	
	@Test
	public void contextLoads() {
		System.out.println("Testing...");
		assertNotNull("Test: Context is null...", ctx);
		DataSource ds=(DataSource)ctx.getBean("postgressDS");
		//assertEquals(ds, null);
		//assertNotNull("Test: Context is null...", ctx);
		assertNotNull("Test: DS postgree is null", ds);
		//assertNotNull("Test: null is null", null);
		System.out.println("test1");
	}

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	@Test
	public void userServiceTest() {
		System.out.println("test2");
		//User u=(User)userService.loadUserByUsername("user");
		Role r=roleDao.findRoleByName("USER");
	    assertNotNull("role USER is null", r);
		assertEquals(r.getRoleName(), "USER");
		
		//userDao.addUser("user", "1111");
		User u=(User)userService.loadUserByUsername("user");
		assertNotNull("user 'user' is null", u);
//		assertNotEquals(u.getUsername(), "user");
		//System.out.println(u.getUsername());
		//
	}
	
}
