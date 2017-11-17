package com.yss1.one;

import com.yss1.one.util.Utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

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
import com.yss1.one.util.Period;
import com.yss1.one.util.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OneApplicationTests {
//	@Autowired
//	ApplicationContext ctx;
	
	@Test
	public void contextLoads() {
		//System.out.println("Testing...");
		//assertNotNull("Test: Context is null...", ctx);
		//DataSource ds=(DataSource)ctx.getBean("postgressDS");
		//assertEquals(ds, null);
		//assertNotNull("Test: Context is null...", ctx);
		//assertNotNull("Test: DS postgree is null", ds);
		//assertNotNull("Test: null is null", null);
		System.out.println("test1");
	}

//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private UserDao userDao;
//	
//	@Autowired
//	private RoleDao roleDao;

	@Test
	public void userServiceTest() {
		System.out.println("test2");
		//User u=(User)userService.loadUserByUsername("user");
		//Role r=roleDao.findRoleByName("USER");
	    //assertNotNull("role USER is null", r);
		//assertEquals(r.getRoleName(), "USER");
		
		//userDao.addUser("user", "1111");
		//User u=(User)userService.loadUserByUsername("user");
		//assertNotNull("user 'user' is null", u);
		//assertNotEquals(u.getUsername(), "user");
		//System.out.println(u.getUsername());
		//
	}
	
	@Test
	public void periodTest() {
		//System.out.println("test3a");
		//Date d1=com.yss1.one.util.Utils.makeDate(1979,2,1);
		//Date d2=com.yss1.one.util.Utils.makeDate(1980,1,31);
		
		//Period p=com.yss1.one.util.Utils.calcPeriod(makeDate(1979,2,1),makeDate(1980,1,31));
		Period p=Utils.calcPeriod(Utils.makeDate(1979,2,1),Utils.makeDate(1980,1,31));
		
		assertEquals(p.getDays(), 1);
		assertEquals(p.getMonths(), 0);
		assertEquals(p.getYears(), 1);
		p=Utils.calcPeriod(Utils.makeDate(1999,3,15),Utils.makeDate(2000,4,10));
		System.out.println(p.toString());
		assertEquals(p.getDays(), 26);
		assertEquals(p.getMonths(), 0);
		assertEquals(p.getYears(), 1);
		System.out.println("test3");
		
	}

	@Test
	public void snilsTest() {
			assertEquals(Utils.rawSNILS("000-000-000 00"), "000000000");
		assertEquals(Utils.rawSNILS("000-111-222 33"), "000111222");
		assertEquals(Utils.rawSNILS("33311122244"), "333111222");
		assertEquals(Utils.rawSNILS("555444333"), "555444333");
		System.out.println("test3");
		
	}
	
	
}
