package com.demmo.spring;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//ApplicationContext ctx= new ClassPathXmlApplicationContext("context.xml");
	 ApplicationContext ctx= new AnnotationConfigApplicationContext(Config.class);    
	//	DAO dao = (DAO)ctx.getBean("hibernateDAO");
   //        System.out.println(dao.saveEmp(new Employee(100,"James","Hyd",3000)));
            
            EmpApp empApp = (EmpApp)ctx.getBean("app");
            System.out.println(empApp.registerEmp(100, "bindh", "tt", 65000));
            
            Object app = ctx.getBean("app");
            System.out.println(app.getClass().getName());
            Method[] methods = app.getClass().getMethods();
            
           /* for(Method  m: methods){
            	System.out.println(m.getName());
            }*/
	}

}
