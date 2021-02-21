package com.solitardj9.msa.serviceInterface.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class EurekaSecurityConfig extends WebSecurityConfigurerAdapter {

	// https://dongdd.tistory.com/175
	// https://velog.io/@gadian88/basic-auth-%EA%B5%AC%ED%98%84-%EB%B0%8F-%EC%84%A4%EB%AA%85
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
        http.csrf().disable();		// basic auth를 사용하기 위해 csrf 보호 기능 disable
    }
}