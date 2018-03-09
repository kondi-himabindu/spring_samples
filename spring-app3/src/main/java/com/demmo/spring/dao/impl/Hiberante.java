package com.demmo.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.demmo.spring.DAO;
import com.demmo.spring.Employee;

public class Hiberante implements DAO{
	
	@Override
	public String saveEmp(Employee e){
		return "Hiberante: Emp Saved";
	}

}
