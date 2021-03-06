package com.demo.spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="EMP")
@XmlRootElement
public class Employee {
	
@Id
@Column(name="EMPNO")
private int empId;
private String name;
private double salary;
@Column(name="ADDRESS")
private String city;

public Employee(int empId, String name,String city, double salary){

	this.empId = empId;
	this.name = name;
	this.city = city;
	this.salary = salary;
    }

    public Employee(){
	 
    }
    public void setEmpId(int empId){
     this.empId = empId;
    }
    
    public int getEmpId(){
    	return this.empId;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
