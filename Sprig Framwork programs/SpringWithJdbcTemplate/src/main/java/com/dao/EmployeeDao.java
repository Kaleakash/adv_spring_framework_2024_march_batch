package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository				// this annotation is dao layer specific annotation 
public class EmployeeDao {
	@Autowired
	JdbcTemplate jdbcTemplate;		// scan jdbcTemplate details in beans.xml file by default by Type.
	
	public int storeEmployee(Employee emp) {
	try {
	return jdbcTemplate.update("insert into employee values(?,?,?)", emp.getId(),emp.getName(),emp.getSalary());
	} catch (Exception e) {
		System.err.println(e);
		return 0;
		}
	}
	public int deleteEmployee(int id) {
		try {
		return jdbcTemplate.update("delete from employee where id =?", id);
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	public int updateEmployee(Employee emp) {
	try {
		return jdbcTemplate.update("update employee set salary = ? where id = ?", emp.getSalary(),emp.getId());
	} catch (Exception e) {
		System.err.println(e);
		return 0;
	}
}
	
	
	public List<Map<String,Object>> findAllEmployeeInListOfMap() {
		try {
			return jdbcTemplate.queryForList("select * from employee");
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	public List<Employee> findAllEmployeeAsAList() {
		try {
			return jdbcTemplate.query("select * from employee", new MyEmployeeRowMapper());
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
}
// global code while retrieve employee records 
class MyEmployeeRowMapper implements RowMapper<Employee>{
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setSalary(rs.getFloat(3));
		return emp;
	}
}

