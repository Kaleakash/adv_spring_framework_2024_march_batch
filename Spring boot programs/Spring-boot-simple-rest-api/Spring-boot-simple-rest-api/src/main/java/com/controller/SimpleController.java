package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

	// http://localhost:8080/say 
	
	@RequestMapping(value = "say")
	public @ResponseBody String sayHello() {
		System.out.println("I came here");
		return "Welcome to Spring boot simple rest api";
	}
}
