package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PaypalMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaypalMicroServiceApplication.class, args);
	}

	// reponsible to create the object of RestTemmplate but maintain by container. 
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
