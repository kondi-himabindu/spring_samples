package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.dao.Employee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		EmpApp app = (EmpApp)ctx.getBean("app");
	//	String resp = app.registerEmp(301, "scott","Hyderbad",65000);
		
		//System.out.println(resp+);
		app.showAllEmps();
	//	System.out.println("found"+ app.findEmp(202));
	
		
	}

}
