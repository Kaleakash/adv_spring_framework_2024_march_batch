package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
	// data {"id":100,"name":"Steven","salary":24000,"designation":"trainer"}
	@RequestMapping(value = "storeEmployee",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeEmployee(@RequestBody Employee employee) {
		return employeeService.storeEmployee(employee);
	}
	// http://localhost:8080/deleteEmployee/100	 method : delete 
	
	@RequestMapping(value = "deleteEmployee/{id}",
			method = RequestMethod.DELETE)
	public String deleteEmloyee(@PathVariable("id") int id) {
		return employeeService.deleteEmployee(id);
	}
	
	// http://localhost:8080/updateEmployeeSalary			method : patch
	// data {"id":100,"salary":24000}
	
		@RequestMapping(value = "updateEmployeeSalary",
				method = RequestMethod.PATCH,
				consumes = MediaType.APPLICATION_JSON_VALUE)
		public String updateEmployeeSalary(@RequestBody Employee employee) {
			return employeeService.updateEmployeeSalary(employee);
		}
		
		// http://localhost:8080/searchEmployeeById/101	
		
		@RequestMapping(value = "searchEmployeeById/{id}",method = RequestMethod.GET)
		public String searchEmployeeById(@PathVariable("id") int id) {
			return employeeService.searchEmployeeById(id);
		}
	
		// http://localhost:8080/searchEmployeeBySalary/20000	
		@RequestMapping(value = "searchEmployeeBySalary/{salary}",method = RequestMethod.GET)
		public List<Employee> findEmployeeBySalary(@PathVariable("salary") float salary){
			return employeeService.searchEmployeeBySalary(salary);
		}
		
		
		
		
		
}

