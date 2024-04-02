package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Account;
import com.service.AccountService;

// http://localhost:9191/account/*
//http://localhost:9191/account/findAll
//http://localhost:9191/account/create
@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
	@GetMapping(value="findAccount/{accno}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Account findAccountDetails(@PathVariable("accno") int accno) {
		return accountService.findAccountById(accno);
	}
	
	@GetMapping(value="findAccNumber/{emailid}")
	public int findAccnoNumber(@PathVariable("emailid") String emailid) {
		try {
		return accountService.findAccNumber(emailid);
		}catch(Exception e) {
			System.err.println(e);
			return -1;
		}
	}
	
	@GetMapping(value="findBalance/{accno}")
	public String findAccountBalance(@PathVariable("accno") int accno) {
		
		return accountService.findBalance(accno);
		
	}
	
}
