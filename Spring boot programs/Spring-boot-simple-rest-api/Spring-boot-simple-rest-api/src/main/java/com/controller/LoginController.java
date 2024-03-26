package com.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	// http://localhost:8080/singleQueryParam?name=Steven
	
	@RequestMapping(value = "singleQueryParam",method = RequestMethod.GET)
	public String singleQueryParam(@RequestParam("name") String fname) {
		return "Welcome to Spring boot with single query param"+fname;
	}
	
	// http://localhost:8080/singlePathParam/Steven
	
	@RequestMapping(value = "singlePathParam/{name}",method = RequestMethod.GET)
	public String singlePathParam(@PathVariable("name") String fname) {
		return "Welcome to Spring boot with single path param"+fname;
	}
	
	// http://localhost:8080/multipleQueryParam?email=raj@gmail.com&password=123
	
	@RequestMapping(value = "multipleQueryParam",method = RequestMethod.GET)
	public String multipleQueryParam(@RequestParam("email") String email, 
			@RequestParam("password") String password) {
		if(email.equals("raj@gmail.com") && password.equals("123")) {
			return "success using query param";
		}else {
			return "failure using query param";
		}
	}
	//  http://localhost:8080/multiplePathParam/raj@gmail.com/123
	
	@RequestMapping(value = "multiplePathParam/{email}/{password}",method = RequestMethod.GET)
	public String multiplePathParam(@PathVariable("email") String email,@PathVariable("password") String password) {
		if(email.equals("raj@gmail.com") && password.equals("123")) {
			return "success using path param";
		}else {
			return "failure using path param";
		}
	}
}
