package com.yss1.one.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yss1.one.util.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/css/*", "/js/*", "/fonts/*").permitAll().anyRequest().authenticated()
				//.antMatchers("*.css").permitAll().anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/")
				.and()
				.logout().permitAll();
	}

	@Autowired
	private UserService userService;

	@Bean
	public PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder amb) throws Exception {
		amb.userDetailsService(userService).passwordEncoder(passEncoder());
	}

}