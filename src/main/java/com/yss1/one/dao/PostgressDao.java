package com.yss1.one.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class PostgressDao {
	@Autowired
	private ApplicationContext ctx;
	protected JdbcTemplate pgDT;

	@PostConstruct
	private void init() {
		pgDT=new JdbcTemplate((DataSource)ctx.getBean("postgressDS"));
	}
}
