package com.yss1.one.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//коннекторы до баз данных
@Configuration
public class DbConfig {
	
	@Primary
	@Bean(name = "postgressDS")
	@ConfigurationProperties("app.datasource.postgressdb")
	public DataSource dataSource1() {
		DataSource ds= new DriverManagerDataSource();
	    return ds;
	}
	
	@Bean(name = "postgressJdbcTemplate")
	@Qualifier("postgressDS")
	public JdbcTemplate postgressJdbcTemplate() {
		//DataSource ds= new DriverManagerDataSource();
		DataSource ds = dataSource1();
		return new JdbcTemplate(ds);
	}
	
	@Bean(name = "as400DataSource")
	@Lazy(value = true)
	@ConfigurationProperties("app.datasource.as400")
	public DataSource dataSource2(){
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
       //dataSource.setDriverClassName("com.ibm.as400.access.AS400JDBCDriver");
       //dataSource.setUrl("jdbc:as400://10.48.0.14");
       //dataSource.setUsername("PD485100");
       //dataSource.setPassword("PD495100");
       return dataSource;
   }
	
	@Bean
	public PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
