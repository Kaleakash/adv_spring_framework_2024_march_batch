package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.Paypal;
import com.repository.PaypalRepository;

@Service
public class PaypalService {

	@Autowired
	PaypalRepository paypalRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	// emailid pid 1, steven@gmail.com 101 
	public String createAccount(Paypal paypal) {
		String emailid = paypal.getEmailid();
		int accno = restTemplate.getForObject("http://localhost:9191/account/findAccNumber/"+emailid, Integer.class);
		paypal.setAccno(accno);
		paypalRepository.save(paypal);
		return "Account Created sucessfully";
	}
}
