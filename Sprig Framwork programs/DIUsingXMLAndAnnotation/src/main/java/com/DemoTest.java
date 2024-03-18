package com;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Employee emp = new Employee();
//		emp.display();
		
	Resource res = new ClassPathResource("beans.xml");
	BeanFactory ref = new XmlBeanFactory(res);
	Employee e1 = (Employee)ref.getBean("emp1");  // pull the object 
	e1.display();
	}

}
