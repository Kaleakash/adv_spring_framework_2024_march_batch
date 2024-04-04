package com.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SuccessHandlerApp extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		boolean isAdmin = authentication.getAuthorities().stream().anyMatch(grant->grant.getAuthority().equals("ROLE_ADMIN"));
		if(isAdmin) {
			setDefaultTargetUrl("/admin");
		}else {
			setDefaultTargetUrl("/user");
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}

}









