package com.demmo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ApplicationContext ctx= new ClassPathXmlApplicationContext("context.xml");
            DAO dao = (DAO)ctx.getBean("jdbcDao");
            System.out.println(dao.saveEmp(new Employee(100,"James","Hyd",3000)));
            
            EmpApp empApp = (EmpApp)ctx.getBean("app");
            System.out.println(empApp.registerEmp(100, "bindh", "tt", 65000));
	}

}
