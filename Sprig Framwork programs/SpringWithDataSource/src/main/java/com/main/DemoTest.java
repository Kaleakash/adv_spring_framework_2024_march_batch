package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.service.EmployeeService;

public class DemoTest {

	public static void main(String[] args) {
	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	EmployeeService es = (EmployeeService)ac.getBean("employeeService");
	Employee emp = (Employee)ac.getBean("employee");
	emp.setId(101);
	emp.setName("Lex");
	emp.setSalary(18000);
	String result = es.storeEmployee(emp);
	System.out.println(result);
	}

}
