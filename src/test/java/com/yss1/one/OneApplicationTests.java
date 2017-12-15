package com.yss1.one;

import com.yss1.one.util.Utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.yss1.one.dao.DojityeDao;
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
	@Autowired
	private DojityeDao dojDao;

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
		Period p=Utils.makePeriod(Utils.makeDate(1979,2,1),Utils.makeDate(1980,1,31),1);
		
		assertEquals(p.getDays(), 1);
		assertEquals(p.getMonths(), 0);
		assertEquals(p.getYears(), 1);
		p=Utils.makePeriod(Utils.makeDate(1999,3,15),Utils.makeDate(2000,4,10),1);
		System.out.println(p.toString());
		assertEquals(p.getDays(), 26);
		assertEquals(p.getMonths(), 0);
		assertEquals(p.getYears(), 1);
		System.out.println("test2");
		
	}

	@Test
	public void dojityeTest() {
		assertEquals(dojDao.getPeriod(1945, false),144);
		assertEquals(dojDao.getPeriod(2014, false),228);
		assertEquals(dojDao.getPeriod(2014, true),240);
		assertEquals(dojDao.getPeriod(2018, false),228);
		assertEquals(dojDao.getPeriod(2018, true),252);
		assertEquals(dojDao.getPeriod(2016, false),228);
		assertEquals(dojDao.getPeriod(2016, true),252);
		assertEquals(dojDao.getPeriod(2029, false),228);
		
		
	}
	
	
	@Test
	public void snilsTest() {
		assertEquals(Utils.rawSNILS("000-000-000 00"), "000000000");
		assertEquals(Utils.rawSNILS("000-111-222 33"), "000111222");
		assertEquals(Utils.rawSNILS("33311122244"), "333111222");
		assertEquals(Utils.rawSNILS("555444333"), "555444333");
		System.out.println("test3");
		
	}
	
	@Test
	public void multPeriodTest() {
		Period period=new Period(1,1,1);
		Period res=Utils.multPeriod(period, 1.5f);
		//System.out.println("year="+res.getYears()+" month="+res.getMonths()+" day="+res.getDays());
		assertEquals(res.getYears(),1);
		assertEquals(res.getMonths(),7);
		assertEquals(res.getDays(),16);
		
		period=new Period(1,11,25);
		res= Utils.multPeriod(period, 1.75f);
		System.out.println("year="+res.getYears()+" month="+res.getMonths()+" day="+res.getDays());
		assertEquals(res.getYears(),3);
		assertEquals(res.getMonths(),5);
		assertEquals(res.getDays(),21);
		
	}
	
	@Test
	public void multPeriodTest2() {
		Period period=new Period(1,1,1);
		Period res= new Period(2,2,2);
		res.diffPeriod(period);
		//System.out.println("year="+res.getYears()+" month="+res.getMonths()+" day="+res.getDays());
		assertEquals(res.getYears(),1);
		assertEquals(res.getMonths(),1);
		assertEquals(res.getDays(),1);
		
		period=new Period(1,11,25);
		res= new Period(5,6,8);
		res.diffPeriod(period);
		
		assertEquals(res.getYears(),3);
		assertEquals(res.getMonths(),6);
		assertEquals(res.getDays(),13);
		
	}
	
	@Test
	public void snilsFormat() {
		assertEquals(Utils.formatSNILS("04971172171"), "049-711-721 71");
		assertEquals(Utils.formatSNILS("049711721"), "049-711-721 71");
		assertEquals(Utils.formatSNILS("049 711 721"), "049-711-721 71");
		assertEquals(Utils.formatSNILS("049-711-721"), "049-711-721 71");
		assertEquals(Utils.formatSNILS("049-711-721 71"), "049-711-721 71");
		assertEquals(Utils.formatSNILS("049 711 721 71"), "049-711-721 71");
		
		System.out.println("test3");
		
	}
	
	
	@Test
	public void dateTest() {
		
		assertTrue(Utils.beforeOrEqual(Utils.makeDate(1999,3,15),Utils.makeDate(1999,3,15)));
		assertTrue(Utils.beforeOrEqual(Utils.makeDate(1999,3,15),Utils.makeDate(1999,3,16)));
		assertTrue(!Utils.beforeOrEqual(Utils.makeDate(1999,3,15),Utils.makeDate(1999,3,14)));
		
		assertTrue(Utils.afterOrEqual(Utils.makeDate(1999,3,15),Utils.makeDate(1999,3,15)));
		assertTrue(!Utils.afterOrEqual(Utils.makeDate(1999,3,15),Utils.makeDate(1999,3,16)));
		assertTrue(Utils.afterOrEqual(Utils.makeDate(1999,3,15),Utils.makeDate(1999,3,14)));
		
		Date d1=new Date(2010,1,1);
		Date d2=new Date(2009,12,31);
		
		
		assertEquals(d1.getTime(),Utils.addDay(d2,1).getTime());
		assertEquals(d2.getTime(),Utils.addDay(d1,-1).getTime());
		//assertEquals(d2.getTime(),Utils.addDay(d1,-2).getTime());
		
		//System.out.println("test4="+Utils.getFormattedDate(Utils.addDay(d1,-1)));
		
	}
	
	@Test
	public void floatTest() {
		assertEquals(Utils.getFloat("jkew jew (000.1)bkj"), 0.1f,0.001f);
		assertEquals(Utils.getFloat("jkew jew (.1)bkj"), 0.1f,0.001f);
		assertEquals(Utils.getFloat("jkew jew (1)bkj"), 1f,0.001f);
		assertEquals(Utils.getFloat("jkew jew (0.88)bkj"), 0.88f,0.001f);
		assertEquals(Utils.getFloat("jkew jew ( 0.88 )bkj"), 0.88f,0.001f);
		assertEquals(Utils.getFloat("(0.88)"), 0.88f,0.001f);
		assertEquals(Utils.getFloat("(.88)"), 0.88f,0.001f);
	}
	
}
