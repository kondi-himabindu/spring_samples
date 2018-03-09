package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.demo.spring.repo")
@EnableEurekaClient
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    SpringApplication.run(App.class,args);
	}

}
