package com.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController    // @controller + @@ResponseBody
public class AnotherController {

	// http://localhost:8080/hi
	
	@RequestMapping(value = "hi")
	public String sayHi() {
		return "Welcome to Simple rest api with hi message";
	}
	// http://localhost:8080/plain
	
	@RequestMapping(value = "plain",method = RequestMethod.GET,produces = MediaType.TEXT_PLAIN_VALUE)
	public String sayPlainText() {
		return "<h2>Welcome to Spring boot rest api</h2>";
	}
	
	// http://localhost:8080/plain
	@RequestMapping(value = "html",method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
	public String sayHtml() {
		return "<h2>Welcome to Spring boot rest api</h2>";
	}
	// http://localhost:8080/plain
	@RequestMapping(value = "xml",method = RequestMethod.GET,produces = MediaType.TEXT_XML_VALUE)
	public String sayXml() {
		return "<abc>Welcome to Spring boot rest api</abc>";
	}
}
