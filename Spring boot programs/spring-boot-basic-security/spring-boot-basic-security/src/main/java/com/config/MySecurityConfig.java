package com.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class MySecurityConfig{

	
	@Bean
	public UserDetailsService userDetilsService() {
		List<UserDetails> listOfUser = new ArrayList<UserDetails>();
		
//		listOfUser.add(User.withUsername("akash").password("{noop}123").build());
//		listOfUser.add(User.withUsername("steven").password("{noop}456").build());
//		listOfUser.add(User.withUsername("lex").password("{noop}678").build());
		
	listOfUser.add(User.withUsername("akash").password("$2a$12$765UMIBHkidIveTMqMSKeuE0hxJ3d3lWQqMR9sekIOLvlPHc5cp.C").build());
	listOfUser.add(User.withUsername("steven").password(passwordEncoder().encode("456")).build());
	listOfUser.add(User.withUsername("lex").password(passwordEncoder().encode("789")).build());
	return new InMemoryUserDetailsManager(listOfUser);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}







