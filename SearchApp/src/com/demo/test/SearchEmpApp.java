package com.demo.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.demo.test.model.Employee;

public class SearchEmpApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> empSet = new ArrayList<>();
		empSet.add(new Employee(100,"James","London",25000));
		empSet.add(new Employee(101,"Scott","London",35000));
		empSet.add(new Employee(102,"Kitty","New York",55000));
		empSet.add(new Employee(103,"Bindu","Bangalore",65000));
		empSet.add(new Employee(104,"Krishna","Mumbai",55000));
		empSet.add(new Employee(105,"Amit","Delhi",45000));
		empSet.add(new Employee(106,"Arun","London",75000));
		empSet.add(new Employee(107,"Kiran","London",65000));
		
		for(Employee e:empSet){
			if(e.getSalary()>40000)
				System.out.println(e.getEmpId()+" "+e.getName()+"  "+e.getCity()+" "+e.getSalary());
		}
	}

}
