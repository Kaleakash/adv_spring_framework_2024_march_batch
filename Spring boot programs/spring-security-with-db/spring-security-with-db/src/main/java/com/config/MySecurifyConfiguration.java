package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurifyConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		
		return httpSecurity.
				authorizeHttpRequests(auth-> {
					auth.requestMatchers("everyone").permitAll();
					auth.requestMatchers("/user/**").hasAnyRole("USER");
					auth.requestMatchers("/admin/**").hasAnyRole("ADMIN");
				}).
				formLogin(form->form.permitAll()).
				build();
	}
	
	@Bean UserDetailsService userDetails() {
		UserDetails normalUser = 
		User.builder().username("akash").password(passwordEncoder().encode("123")).roles("USER").build();
		UserDetails adminUser = 
		User.builder().username("admin").password(passwordEncoder().encode("456")).roles("ADMIN","USER").build();
		return new InMemoryUserDetailsManager(normalUser,adminUser);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}



