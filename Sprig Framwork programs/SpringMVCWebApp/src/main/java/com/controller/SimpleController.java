package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "loginCheck",method = RequestMethod.GET)
	public ModelAndView checkLoginInfoWithGet(HttpServletRequest req) { // DI for HttpServletRequest 
	String emailid = req.getParameter("emailid");
	String password = req.getParameter("password");
	ModelAndView mav = new ModelAndView();
	
	if(emailid.equals("akash@gmail.com") && password.equals("123")) {
		mav.setViewName("success.jsp");
	}else {
		mav.setViewName("failure.jsp");
	}
	return mav;
	}
	
	@RequestMapping(value = "loginCheck",method = RequestMethod.POST)
	public ModelAndView checkLoginInfoWithPost(HttpServletRequest req) { // DI for HttpServletRequest 
	String emailid = req.getParameter("emailid");
	String password = req.getParameter("password");
	ModelAndView mav = new ModelAndView();
	
	if(emailid.equals("akash@gmail.com") && password.equals("123")) {
		mav.setViewName("success.jsp");
	}else {
		mav.setViewName("failure.jsp");
	}
	return mav;
	}
}



