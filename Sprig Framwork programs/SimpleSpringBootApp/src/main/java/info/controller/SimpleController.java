package info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {
	
	@RequestMapping(value = "/")
	public String openPage() {
		System.out.println("I Cam Here");
		// we can do initialization 
		//return "welcome";			// it open index.html page part of template folder 
		return "index";
	}
}
