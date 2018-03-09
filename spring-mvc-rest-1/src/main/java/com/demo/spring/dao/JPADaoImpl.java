package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JPADaoImpl implements Dao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public String save(Employee e) {
		em.persist(e);
	return "success";
	}

	@Override
	public String deleteEmp(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> listAllEmps() {
		// TODO Auto-generated method stub
		Query query= em.createQuery("select o from Employee o");
		List<Employee> emps1 = query.getResultList();
		return emps1;
	}

	@Override
	public Employee findEmpById(int id) {
		Employee x = em.find(Employee.class,id);
		return x;
	}

	@Override
	public String saveList(List<Employee> emps) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
