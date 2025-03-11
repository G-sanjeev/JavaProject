package com.learn.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

public class MySecurity {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.requestMatchers("/h2-console/**").authenticated()
		.requestMatchers("/**").hasRole("ADMIN").anyRequest().authenticated()
		.and()
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.formLogin()
		.loginPage("/home")
		.failureUrl("/home/failed")
		.loginProcessingUrl("/home/process")
		.and()
		.logout()
		.permitAll();

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.withDefaultPasswordEncoder().username("sanjeev").password("123").roles("ADMIN")
				.build();

		UserDetails user = User.withDefaultPasswordEncoder().username("hari").password("234").roles("USER").build();

		return new InMemoryUserDetailsManager(admin, user);
	}


}
