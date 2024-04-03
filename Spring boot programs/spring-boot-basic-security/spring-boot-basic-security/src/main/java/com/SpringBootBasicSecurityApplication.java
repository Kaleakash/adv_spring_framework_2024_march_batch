package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SpringBootBasicSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicSecurityApplication.class, args);
		System.out.println("spring boot security app up!");
	}

}
