package info.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {
	
	@RequestMapping(value = "/")
	public String openPage() {
		System.out.println("I Cam Here");
		// we can do initialization 
		//return "welcome";			// it open index.html page part of template folder 
		return "index";
	}
	
	@RequestMapping(value = "loginInfo",method = RequestMethod.POST)
	public String checkLoginInfo(HttpServletRequest req) {
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		if(emailid.equals("akash@gmail.com") && password.equals("123")) {
				return "success";
		}else {
				return "failure";
		}
	}
	
}




