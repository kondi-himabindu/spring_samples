package com.demo.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.Employee;

@Repository
public interface EmpRepo extends CrudRepository<Employee, Integer> {

	@Query("select e from Employee e where e.salary>?")
	public List<Employee> getAllBySalary(double salary);
}
