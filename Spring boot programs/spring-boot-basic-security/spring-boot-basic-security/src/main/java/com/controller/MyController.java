package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping(value = "")
	public String sayHello() {
		return "Welcome to Simple Spring boot security ";
	}
}
