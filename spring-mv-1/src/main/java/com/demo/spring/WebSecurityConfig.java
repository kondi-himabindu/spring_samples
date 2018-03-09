package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
/*	@Override
	protected void configure(HttpSecurity http) throws Exception{
	  http.authorizeRequests().antMatchers("/*").hasRole("USER").and().httpBasic();	
	}*/
	@Override
	protected void configure(HttpSecurity http) throws Exception{
	  http.authorizeRequests().antMatchers("/*").hasRole("USER").and().formLogin();	
	}
/*	@Autowired //here AuthenticationManagerBuilder is injected by spring
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("arun").password("welcome1").roles("USER").disabled(true);
		auth.inMemoryAuthentication().withUser("pavan").password("welcome1").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("shantanu").password("welcome1").roles("USER");
	}*/
	
	@Bean
	public DriverManagerDataSource ds(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springdb");
        ds.setUsername("root");
        ds.setPassword("password");
        return ds;
	}
	
	@Autowired //here AuthenticationManagerBuilder is injected by spring
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(ds());
	}
}
