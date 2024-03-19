package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service 						// service layer annotation 
public class EmployeeService {

	@Autowired
	EmployeeDao empoyeeDao;
	
	public String storeEmployee(Employee emp) {
		if(emp.getSalary()<15000) {
			return "Salary must be > 15000";
		}else if(empoyeeDao.storeEmployee(emp)>0) {
			return "Employee record inserted in database";
		}else {
			return "Employee record didn't insert";
		}
	}
	
}
