package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringBootReativeRestApiConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReativeRestApiConsumerApplication.class, args);
		System.out.println("product consumer rest api ");
	}
	@Bean
	public WebClient.Builder webClient() {
		return WebClient.builder();
	}

}
