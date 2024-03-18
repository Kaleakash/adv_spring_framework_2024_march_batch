package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component					// <bean class="com.Employee"></bean>
public class Employee {		// by default id name is class name using camel naming rules. ie employee 
private int id;
private String name;
private float salary;
@Autowired
private Address add;
	public Employee() {
	System.out.println("object created with empty constructor");
	}
	
	public Employee(int id, String name, float salary) {
		super();
		System.out.println("object created with parameter");
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	public Employee(int id, String name, float salary, Address add) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.add = add;
	}

	public void display() {
		System.out.println("This is employee class method");
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", add=" + add + "]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
}
