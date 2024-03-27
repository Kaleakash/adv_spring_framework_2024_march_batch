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
		if(result.isPresent()) {
			return "Employee id must be unique";
		}else {
			employeeRepository.save(emp);
			return "Employee record saved sucessfully";
		}
	}
	
	public String deleteEmployee(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		if(result.isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee record deleted successfully";
		}else {
			return "Employee record not present";
		}
	}
	
	public String updateEmployeeSalary(Employee emp) {
		Optional<Employee> result = employeeRepository.findById(emp.getId());
		if(result.isPresent()) {
				Employee empdb = result.get();
			empdb.setSalary(emp.getSalary());
			employeeRepository.saveAndFlush(empdb);
			return "Employee salary updated successfully";
		}else {
			return "Employee record not present";
		}
	}
	
	public String searchEmployeeById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		if(result.isPresent()) {
			Employee emp = result.get();
			return emp.toString();
		}else {
			return "Record not present";
		}
	}
	
	public List<Employee> searchEmployeeById(float salary) {
			return employeeRepository.findEmployeeBySalary(salary);
	}
	
}


