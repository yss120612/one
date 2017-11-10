package com.yss1.one;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

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
		assertNotNull("Test: null is null", null);
	}

}
