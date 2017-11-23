package com.yss1.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.yss1.one.util.ApplicationContextUtil;


public class WebInit extends SpringBootServletInitializer{
		@Autowired
		private ApplicationContext ctx;
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			SpringApplicationBuilder sbab=application.sources(OneApplication.class);
			ApplicationContextUtil acu=new ApplicationContextUtil();
			acu.setApplicationContext(ctx);
			return sbab;
			
			
			
		}
		
		
	}


