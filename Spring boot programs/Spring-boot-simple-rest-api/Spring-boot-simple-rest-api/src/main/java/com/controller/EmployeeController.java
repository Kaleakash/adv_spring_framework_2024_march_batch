package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;

@RestController
public class EmployeeController {

	// http://localhost:8080/employee 
	
	@RequestMapping(value = "employee",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeInfo() {
		Employee emp = new Employee(100, "Steven", 45000);
		return emp;
	}
	
	
	// http://localhost:8080/employees
	
	@RequestMapping(value = "employees",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeesInfo() {
		Employee emp1 = new Employee(101, "Steven", 45000);
		Employee emp2 = new Employee(102, "Lex", 48000);
		Employee emp3 = new Employee(103, "Neena", 52000);
		List<Employee> listOfEmp  = new ArrayList<>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		return listOfEmp;
	}
}
