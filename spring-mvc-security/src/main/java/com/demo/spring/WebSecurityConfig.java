package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
	  http.authorizeRequests().antMatchers("/*").hasRole("USER").and().httpBasic();	
	}
    
	@Autowired //here AuthenticationManagerBuilder is injected by spring
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("arun").password("welcome1").roles("USER").disabled(true);
		auth.inMemoryAuthentication().withUser("pavan").password("welcome1").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("shantanu").password("welcome1").roles("USER");
	}
	
}