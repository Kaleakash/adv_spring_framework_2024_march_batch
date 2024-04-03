package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SimpleController {

	@GetMapping(value = "mono")
	public Mono<String> simpleReativeAPI() {
		return Mono.just("Welcome to Simple REst API");
	}
	
	@GetMapping(value = "flux")
	public Flux<String> simpleFluxAPI() {
		return Flux.just("Steven","Ravi","Raju","Lex");
	}
}
