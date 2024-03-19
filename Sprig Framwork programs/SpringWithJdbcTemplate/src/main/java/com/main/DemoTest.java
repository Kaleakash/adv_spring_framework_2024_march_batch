package com.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.service.EmployeeService;

public class DemoTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	EmployeeService es = (EmployeeService)ac.getBean("employeeService");
	String con = "";
	int id;
	String name;
	float salary;
	String result;
	do {
		System.out.println("1:Add Employee 2 : Delete Employee 3 : Update Employee 4 : Retieve Employee as a list 5 : Retrieve Employee as Map");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: 
				System.out.println("Enter your id");
				id = sc.nextInt();
				System.out.println("Enter your name");
				name = sc.next();
				System.out.println("Enter your salary");
				salary = sc.nextFloat();
				Employee emp1 = (Employee)ac.getBean("employee");
				emp1.setId(id);
				emp1.setName(name);
				emp1.setSalary(salary);
				result = es.storeEmployee(emp1);
				System.out.println(result);
				break;
		case 2:System.out.println("Enter your id");
			id = sc.nextInt();
			result = es.deleteEmployee(id);
			System.out.println(result);
			break;
		case 3 :System.out.println("Enter your id");
			id = sc.nextInt();
			
			System.out.println("Enter your salary");
			salary = sc.nextFloat();
		
			Employee emp2 = (Employee)ac.getBean("employee");
			emp2.setId(id);
			
			emp2.setSalary(salary);
			result = es.updateEmployee(emp2);
			System.out.println(result);
			break;
		case 4 : System.out.println("All records as list");
		         es.findAllEmployee().forEach(emp->System.out.println(emp));
		         break;
		case 5 : System.out.println("All records as map");
		         List<Map<String, Object>> ll = es.findAllEmployeeAsMap();
		         Iterator<Map<String, Object>> li = ll.iterator();
		         while(li.hasNext()) {
		        	 Map<String, Object> mm = li.next();
		        	 System.out.println(mm);
		         }
		         break;
		default:System.out.println("Wrong choice");
			
		}
		
		System.out.println("do you want to continue(y/n)");
		con = sc.next();
	} while (con.equalsIgnoreCase("y"));
	
	System.out.println("Thank you!");
	}

}
