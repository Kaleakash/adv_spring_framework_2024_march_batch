package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entity.Login;
import com.repository.LoginRepository;

@Service
public class LoginService implements UserDetailsService{
	
	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Login> result = loginRepository.findUserByName(username);
		if(result.isPresent()) {
			Login ll  = result.get();
	return User.builder().username(ll.getUsername()).password(ll.getPassword()).roles(getRoles(ll)).build();
		}else {
			throw new UsernameNotFoundException(username);
		}

	}

	public String[] getRoles(Login ll) {
		if(ll.getRole()==null) {
			return new String[] {"USER"};
		}else {
			return ll.getRole().split(",");
		}
	}
	
	public String createAccount(Login ll) {
		Optional<Login> result = loginRepository.findUserByName(ll.getUsername());
		if(result.isPresent()) {
			return "User already exists";
		}else {
			loginRepository.save(ll);
			return "Account created successfully";
		}
		
	}
}
