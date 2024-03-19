package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.service.EmployeeService;

public class DemoTest {

	public static void main(String[] args) {
	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	EmployeeService es = (EmployeeService)ac.getBean("employeeService");
	// insert record 
//	Employee emp = (Employee)ac.getBean("employee");
//	emp.setId(101);
//	emp.setName("Lex");
//	emp.setSalary(18000);
//	String result = es.storeEmployee(emp);
//	System.out.println(result);
	
	// delete employee 
//	String result = es.deleteEmployee(100);
//	System.out.println(result);
	
	// update employee 
//	Employee emp = (Employee)ac.getBean("employee");
//	emp.setId(100);
//	emp.setSalary(45000);
//	String result = es.updateEmployee(emp);
//	System.out.println(result);
	
	// find the records using java 8 features 
	es.findAllEmployee().forEach(e->System.out.println(e));
	}

}
