package info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.bean.Login;

@Controller
public class LoginController {

		// http://localhost:8080/login 	with Get method 
	
		@RequestMapping(value = "/login",method = RequestMethod.GET)
		public String openLoginPage(Login login,Model mm) {	// DI for login and model 
			mm.addAttribute("ll", login);	// object set in model scope. 
			
			return "login";		// login.html page open 
		}
		@RequestMapping(value = "loginCheck",method = RequestMethod.POST)
		public String checkLoginDetails(Login ll) {
			if(ll.getEmailid().equals("akash@gmail.com") &&  ll.getPassword().equals("123")) {
				return "success";
			}else {
				return "failure";
			}
		}
}
