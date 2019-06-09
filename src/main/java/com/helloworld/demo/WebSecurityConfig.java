package com.helloworld.demo;

import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
			http
		    		.authorizeRequests()
		    		.antMatchers("/").permitAll()
		    		.antMatchers("/user/view/**").hasAnyRole("USER","ADMIN")
		    		.anyRequest().authenticated()
		    		.and()
		    		.formLogin()
		    		.loginPage("/login")
		    		.permitAll()
		    		.and()
		    		.logout()
		    		.permitAll();
	    
	}
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select email, password, mobile_number, first_name, last_name, dob, gender"
						+ " from users where email=?")
				.authoritiesByUsernameQuery("select email, role from user_roles where email=?");
	}
	

}
