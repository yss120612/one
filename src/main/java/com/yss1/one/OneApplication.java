package com.yss1.one;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}
	
	
//	@Value("${app.datasource.postgressdb.username}")
//	String userPG;
//	@Value("${app.datasource.postgressdb.password}")
//	String passPG;
//	
//
//	@Bean(name = "postgressDS")
//    public DataSource dataSource1(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://10.48.0.196:5432/pproc");
//        dataSource.setUsername( userPG);
//        dataSource.setPassword( passPG );
//        return dataSource;
//    }
//	
	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.postgressdb")
	public DataSourceProperties dataSourceProperties1() {
	    return new DataSourceProperties();
	}

	@Bean(name = "postgressDS")
	@Primary
	@ConfigurationProperties("app.datasource.postgressdb")
	public DataSource dataSource1() {
	    return dataSourceProperties1().initializeDataSourceBuilder().build();
	    //return (DataSource) DataSourceBuilder.create().type(DataSource.class).build();
	}
	
	@Bean
	@Primary
	public PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	@Primary
//	@ConfigurationProperties("app.datasource.as400")
//	public DataSourceProperties dataSourceProperties2() {
//	    return new DataSourceProperties();
//	}
//
//	@Bean(name = "as400")
//	@ConfigurationProperties("app.datasource.as400")
//	public DataSource dataSource2() {
//		//return (DataSource) DataSourceBuilder.create().type(DataSource.class).build();
//		return dataSourceProperties2().initializeDataSourceBuilder().build();
//	}
	
	
	
	@Bean(name = "postgressJdbcTemplate")
	public JdbcTemplate postgressJdbcTemplate()
	{
		DataSource ds=dataSource1();
		return new JdbcTemplate(ds);
	}
	
	
	
}
