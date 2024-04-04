package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.service.LoginService;



@Configuration
@EnableWebSecurity
public class MySecurifyConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		
		return httpSecurity.
				csrf(csrf->csrf.disable()).
				authorizeHttpRequests(auth-> {
					auth.requestMatchers("everyone","register","signup","signupindb").permitAll();
					auth.requestMatchers("/user/**").hasAnyRole("USER");
					auth.requestMatchers("/admin/**").hasAnyRole("ADMIN");
					auth.anyRequest().authenticated();
				}).
				//formLogin(form->form.permitAll()).		// it open pre-defined login page
				formLogin(form->form.loginPage("/login").
						//successForwardUrl("/user").
						successHandler(new SuccessHandlerApp()).
						permitAll()). // it open custom login page 
				build();
	}
	
//	@Bean UserDetailsService userDetails() {
//		UserDetails normalUser = 
//		User.builder().username("akash").password(passwordEncoder().encode("123")).roles("USER").build();
//		UserDetails adminUser = 
//		User.builder().username("admin").password(passwordEncoder().encode("456")).roles("ADMIN","USER").build();
//		return new InMemoryUserDetailsManager(normalUser,adminUser);
//	}
	
	
	@Autowired 
	LoginService loginService;			// it is a type of UserDetailsService 
	
	@Bean
	public UserDetailsService userDetailService() {
		return loginService;
	}
	
	// it is uses to connect spring security with DAO layer 
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
		dap.setUserDetailsService(loginService);
		dap.setPasswordEncoder(passwordEncoder());
		return dap;
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}



