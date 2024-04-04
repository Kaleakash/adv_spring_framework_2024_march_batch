package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.entity.Login;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	// http://localhost:8080/register , method : post 
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping(value = "login")
	public String loginPage(Login login,Model model) {
		model.addAttribute("login", login);
		return "index";
	}
	@GetMapping(value = "signup")
	public String signUpPage(Login login,Model model) {
		model.addAttribute("login", login);
		return "signup";
	}
}
