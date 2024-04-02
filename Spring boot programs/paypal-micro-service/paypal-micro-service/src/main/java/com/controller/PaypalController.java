package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Paypal;
import com.service.PaypalService;

@RestController
@RequestMapping("paypal")
public class PaypalController {

	@Autowired
	PaypalService paypalService;
	
	@PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createAccount(@RequestBody Paypal paypal) {
		return paypalService.createAccount(paypal);
	}
	
	@GetMapping(value = "findBalance/{pid}")
	public String findBalance(@PathVariable("pid") int pid) {
		return paypalService.findBalane(pid);
	}
}



