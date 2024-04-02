package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Account;
import com.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public String createAccount(Account account) {
		Optional<Account> result = accountRepository.findById(account.getAccno());
		if(result.isPresent()) {
			return "Account already exists";
		}else {
			accountRepository.save(account);
			return "Account created successfully";
		}	
	}
	public Account findAccountById(int accno) {
		Optional<Account> result = accountRepository.findById(accno);
		if(result.isPresent()) {
			Account ac = result.get();
			return ac;
		}else {
			return null;
		}	
	}
	
	public int	findAccNumber(String emailid) {
		return accountRepository.findAccountNumber(emailid);
	}
	
	public String findBalance(int accno) {
		try {
		return "Your account balance is "+accountRepository.findBalance(accno);
		}catch(Exception e) {
			System.err.println(e);
			return "Invalid Account number";
		}
	}
	
	
}
