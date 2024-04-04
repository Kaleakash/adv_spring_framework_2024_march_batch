package com.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	public String signIn();
	public String signUp();
}


class LoginServiceImpl implements LoginService {

	// LoginDao loginDao;
	@Override
	public String signIn() {
		// calling DAO methods 
		return null;
	}

	@Override
	public String signUp() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}