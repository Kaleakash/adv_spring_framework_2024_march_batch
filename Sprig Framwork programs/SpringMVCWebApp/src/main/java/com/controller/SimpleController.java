package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller			// it is like a servlet program 
public class SimpleController {

	@RequestMapping(value = "say")	// by default it consider as get 
	public ModelAndView sayHello() {
		System.out.println("I came here");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("display.jsp");
		return mav;
	}
}
