package com.demmo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void  main(String arg[]){
 ApplicationContext ctx= new ClassPathXmlApplicationContext("context.xml");
 Mail m = (Mail) ctx.getBean("mail");
 System.out.println(m.getMessage().getContent());
}
}
