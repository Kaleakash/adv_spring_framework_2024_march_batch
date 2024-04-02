package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@RequestMapping(value = "/")
	public String sayHi() {
		return "Welcome to Spring boot with second micro service project";
	}
}
