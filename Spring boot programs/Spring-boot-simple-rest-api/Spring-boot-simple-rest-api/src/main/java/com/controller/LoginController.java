package com.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Login;

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
	public String multiplePathParam(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		if(email.equals("raj@gmail.com") && password.equals("123")) {
			return "success using path param";
		}else {
			return "failure using path param";
		}
	}
	
	@RequestMapping(value = "postTest",method = RequestMethod.POST)
	public String postMethodTest() {
		System.out.println("post request");
		return "Post test method";
	}
	// http://localhost:8080/signUp , method post 
	// data in json format {"emailid":"akash@gmail.com", "password":"123"}
	
	@RequestMapping(value = "signUp",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login login) { // @RequestBody to extra json data from request body 
		System.out.println(login);   // it call tostring method 
		return "done";
	}
	
	// http://localhost:8080/changePassword , method put
	// data in json format {"emailid":"akash@gmail.com", "password":"123"}
	
	@RequestMapping(value = "changePassword",method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String changePassword(@RequestBody Login login) {
		System.out.println(login);
		System.out.println("call service layer to change the password");
		return "password change done";
	}
	
	// http://localhost:8080/deleteAccount/raj@gmail.com
	
	@RequestMapping(value = "deleteAccount/{emailid}",method = RequestMethod.DELETE)
	public String deleteAccount(@PathVariable("emailid") String emailid) {
		System.out.println("your account deleted");
		return "You account deleted"+emailid;
	}
	
	
}


