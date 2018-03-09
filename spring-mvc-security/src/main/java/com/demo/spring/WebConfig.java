
package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@ComponentScan(basePackages ="com.demo.spring")
@EnableWebMvc
public class WebConfig {

	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver rs = new InternalResourceViewResolver();
		rs.setPrefix("/WEB-INF/pages/");
		rs.setSuffix(".jsp");
		rs.setOrder(1);
		return rs;
	}
	
	@Bean
	public ViewResolver viewResolver1(){
		ResourceBundleViewResolver vr = new ResourceBundleViewResolver();
		vr.setBasename("views");
		vr.setOrder(0);
		return vr;
	}
}
