package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.service.EmployeeService;

@RestController
public class EmployeeController {

	// http://localhost:8080/findAllEmployees
	
	@Autowired
	EmployeeService employeeService;
	@RequestMapping(value = "findAllEmployees",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findAllEmployee() {
		return employeeService.findAllEmployee();
	}
	
	// http://localhost:8080/storeEmployee			method : post 
	// data {"id":100,"name":"Steven","salary":24000}
	@RequestMapping(value = "storeEmployee",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeEmployee(@RequestBody Employee employee) {
		return employeeService.storeEmployee(employee);
	}
	
	
	
	
	
	
}
