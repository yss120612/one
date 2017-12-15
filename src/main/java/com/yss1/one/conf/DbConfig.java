package com.yss1.one.conf;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jdbc.datasource.lookup.SingleDataSourceLookup;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yss1.one.util.ApplicationContextUtil;


//коннекторы до баз данных
@Configuration
public class DbConfig {
	
	
	@Autowired
	private ApplicationContext ctx;
	@PostConstruct 
	private void init()
	{
		ApplicationContextUtil atu=new ApplicationContextUtil();
		atu.setApplicationContext(ctx);
	}
	
	
//	@Bean(name = "as400DataSource")
//	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//	@Lazy(value = true)
//	@ConfigurationProperties("app.datasource.as400")
//	public DataSource dataSource2(){
//		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
//        return dataSource;
//   }
	
	
	@Primary
	@Bean(name = "postgressDS")
	@ConfigurationProperties("app.datasource.postgressdb")
	public DataSource dataSource1() {
		DataSource ds= new DriverManagerDataSource();
		
	    return ds;
	}
	
	@Bean(name = "as400DataSource")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Lazy(value = true)
	@ConfigurationProperties("app.datasource.as400")
	public DataSource dataSource2(){
		DataSource dataSource = new SingleConnectionDataSource();
        return dataSource;
   }
	
	
	
//	@Bean(name = "as400DataSource")
//	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//	@Lazy(value = true)
//	@ConfigurationProperties("app.datasource.as400")
//	public DataSource dataSource2(){
//		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//		DataSource dataSource = dsLookup.getDataSource("java:/AS400DS");
//		
//		
//        return dataSource;
//  }
//	
//	@Primary
//	@Bean(name = "postgressDS")
//    public DataSource dataSource1() {
//        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//        dsLookup.setResourceRef(true);
//        DataSource dataSource = dsLookup.getDataSource("java:/PostgresDS");
//        return dataSource;
//    }
	
	@Bean(name = "postgressJdbcTemplate")
	@Qualifier("postgressDS")
	public JdbcTemplate postgressJdbcTemplate() {
		//DataSource ds= new DriverManagerDataSource();
		DataSource ds = dataSource1();
		return new JdbcTemplate(ds);
	}
	
	@Bean
	public PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
