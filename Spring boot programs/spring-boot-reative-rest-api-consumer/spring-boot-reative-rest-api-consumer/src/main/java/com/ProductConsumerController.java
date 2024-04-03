package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("productconsumer")
public class ProductConsumerController {

	@Autowired
	WebClient.Builder webClientBuilder;
	// http://localhost:9090/productconsumer/mono
	
	@GetMapping(value = "mono")
	public Mono<String> getMono() {
	return webClientBuilder.build().get().uri("http://localhost:8080/mono").retrieve().bodyToMono(String.class);
	}
	
//	@GetMapping(value = "fluxproduct")
//	public Flux<Product> getProductFlux() {
//	return webClientBuilder.build().get().uri("http://localhost:8080/product/findProducts").retrieve().bodyToFlux(Product.class);
//	}
	
}




















