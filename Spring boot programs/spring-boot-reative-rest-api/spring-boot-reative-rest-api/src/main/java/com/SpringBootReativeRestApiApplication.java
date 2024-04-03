package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SpringBootReativeRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReativeRestApiApplication.class, args);
		System.out.println("spring boot reactive up!");
	}

}
