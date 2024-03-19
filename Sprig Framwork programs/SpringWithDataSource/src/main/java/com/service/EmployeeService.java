package com.service;

import java.util.Iterator;
import java.util.List;

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
	
	public String deleteEmployee(int id) {
		if(empoyeeDao.deleteEmployee(id)>0) {
			return "Employee record deleted successfully";
		}else {
			return "Employee record not present";
		}
	}
	
	public String updateEmployee(Employee emp) {
		if(empoyeeDao.updateEmployee(emp)>0) {
			return "Employee record updated successfully";
		}else {
			return "Employee record not present";
		}
	}
	
	public List<Employee> findAllEmployee() {
			List<Employee> listOfEmp = empoyeeDao.findAll();
			Iterator<Employee> li = listOfEmp.iterator();
			while(li.hasNext()) {
				Employee emp = li.next();
				emp.setSalary(emp.getSalary()+2500);
			}
			
			return listOfEmp;
	}
}


