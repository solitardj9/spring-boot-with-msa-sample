package com.solitardj9.msa.serviceInterface.common;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ENDPOINT_ADMIN")
			.and()
			.httpBasic()
			;
	}
}