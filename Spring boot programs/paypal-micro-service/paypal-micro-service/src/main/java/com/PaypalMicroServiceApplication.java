package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
@EnableJpaRepositories(basePackages = "com.repository")
@EnableDiscoveryClient
public class PaypalMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaypalMicroServiceApplication.class, args);
		System.err.println("paypal micro service up!");
	}

	// responsible to create the object of RestTemmplate but maintain by container. 
	@Bean
	@LoadBalanced		// paypal micro service can communicate with account micro service using service name.
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
