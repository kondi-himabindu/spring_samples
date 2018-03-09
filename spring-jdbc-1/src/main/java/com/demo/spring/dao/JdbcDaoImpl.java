package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JdbcDaoImpl implements Dao {

	@Autowired
	JdbcTemplate jt;
	@Override
	public String save(Employee e) {
		int row = jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			
				PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?,?)");
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3,e.getCity());
				pst.setDouble(4, 56000);
				return pst;
			}
		});
		if(row == 1)
		return "Success..";
        return "failure";
	}

	@Override
	public String deleteEmp(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> listAllEmps() {
		List<Employee> e1 = jt.query("select * from emp", new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				 Employee e = new Employee(rs.getInt("empno"),rs.getString("Name"),rs.getString("Address"),rs.getDouble("salary"));
					return e;
				}
				 
			});
		return e1;
	}

	/*@Override
	
		// TODO Auto-generated method stub
  Employee e = null;
  try{
  e = jt.queryForObject("select * from emp where empno="+id, new RowMapper<Employee>() {

	@Override
	public Employee mapRow(ResultSet arg0, int arg1) throws SQLException {
	Employee e1=jt.queryForObject("select * from emp where empno="+id, new RowMapper<Employee>(){

		@Override
		public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
			 Employee e = new Employee(rs.getInt("empno"),rs.getString("Name"),rs.getString("Address"),rs.getDouble("salary"));
				return e;
		}
		
	});
	}catch(Exception ea){
		System.out.println("No emploee with given ID");
	}
	return e;	
  }*/
	public Employee findEmpById(int id) {
    Employee e = null;
    try{
    e = jt.queryForObject("select * from emp where empno="+id, new RowMapper<Employee>() {

    	   @Override
    		public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
    			 Employee e = new Employee(rs.getInt("empno"),rs.getString("Name"),rs.getString("Address"),rs.getDouble("salary"));
    				return e;
    		}
    		
    	});
    }catch(Exception ex){
    	System.out.println("No emploee with given ID");
    
    }
	return e;
	}

	@Override
	@Transactional
	public String saveList(List<Employee> emps) {
		
		for(Employee e:emps){
			save(e);
		}
		return "Success";
	}
	
	
	

}
