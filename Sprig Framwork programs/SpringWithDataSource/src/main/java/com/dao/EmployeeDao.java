package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository				// this annotation is dao layer specific annotation 
public class EmployeeDao {

	@Autowired				// byType 
	DataSource ds; // before spring framework we were search data source using JNDI look up in application server 
	
	public int storeEmployee(Employee emp) {
		try {
		Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");
		pstmt.setInt(1, emp.getId());
		pstmt.setString(2, emp.getName());
		pstmt.setFloat(3, emp.getSalary());
		return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
}



