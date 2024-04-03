package com.service;

import java.util.Optional;

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
	

	public String createAccount(Paypal paypal) {
		String emailid = paypal.getEmailid();
		//int accno = restTemplate.getForObject("http://localhost:9191/account/findAccNumber/"+emailid, Integer.class);
		int accno = restTemplate.getForObject("http://ACCOUNT-MICRO-SERVICE/account/findAccNumber/"+emailid, Integer.class);
		paypal.setAccno(accno);
		paypalRepository.save(paypal);
		return "Account Created sucessfully";
	}
	
	public String findBalane(int pid) {
		Optional<Paypal> result = paypalRepository.findById(pid);
		if(result.isPresent()) {
	Paypal paypal = result.get();
		int accno = paypal.getAccno();
		if(accno==-1) {
			return "Your paypal account not link with any account";
		}else {
			
		//String output = restTemplate.getForObject("http://localhost:9191/account/findBalance/"+accno, String.class);	
		String output = restTemplate.getForObject("http://ACCOUNT-MICRO-SERVICE/account/findBalance/"+accno, String.class);
		return output;
		}
		}else {
			return "Paypal account not exists";
		}

	}
	
}
