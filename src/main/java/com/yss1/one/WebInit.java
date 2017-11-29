package com.yss1.one;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


public class WebInit extends SpringBootServletInitializer{
		
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			SpringApplicationBuilder sbab=application.sources(OneApplication.class);
			return sbab;
		}
		
		
		
	}


