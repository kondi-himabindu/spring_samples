package com.demmo.spring;

public class EmpApp {
DAO dao;
public void setDao(DAO dao) {
	this.dao = dao;
}
public String registerEmp(int id,String name,String city, double sal){
	
	String s = dao.saveEmp(new Employee(id, name,city,sal));
	System.out.println(s);
	return "Employee rEgistered";
}
}
