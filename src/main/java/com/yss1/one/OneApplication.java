package com.yss1.one;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class OneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}
	
	
	@Value("${application.db1.username}")
	String userPG;
	@Value("${application.db1.password}")
	String passPG;
	
	@Bean(name = "postgressDS")
    public DataSource dataSource1(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://10.48.0.196:5432/pproc");
        dataSource.setUsername(userPG);
        dataSource.setPassword( passPG );
        return dataSource;
    }
	
	
	
}
