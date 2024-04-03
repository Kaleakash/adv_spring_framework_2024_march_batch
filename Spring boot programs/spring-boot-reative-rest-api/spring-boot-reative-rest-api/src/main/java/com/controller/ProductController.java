package com.controller;

import javax.print.attribute.standard.Media;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {

	@GetMapping(value = "findProduct",produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Product> getProductInfo() {
		Product p1 = new Product(1,"TV",56000);
		return Mono.just(p1);
	}
	@GetMapping(value = "findProducts",produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Product> getProducts() {
		Product p1 = new Product(1,"TV",56000);
		Product p2 = new Product(2,"Computer",34000);
		Product p3 = new Product(3,"Laptop",87000);
		
		return Flux.just(p1,p2,p3);
	}
	
	
}
