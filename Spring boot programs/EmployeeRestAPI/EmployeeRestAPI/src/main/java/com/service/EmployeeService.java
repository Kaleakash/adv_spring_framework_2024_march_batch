package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public String storeEmployee(Employee emp) {
		Optional<Employee> result = employeeRepository.findById(emp.getId());
		if(result.isEmpty()) {
			return "Employee id must be unique";
		}else {
			employeeRepository.save(emp);
			return "Employee record saved sucessfully";
		}
	}
}
