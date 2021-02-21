package com.solitardj9.msa.systemInterface.authServiceInterface.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.solitardj9.msa.systemInterface.authServiceInterface.model.AuthToken;
import com.solitardj9.msa.systemInterface.authServiceInterface.model.TokenResponseDto;
import com.solitardj9.msa.systemInterface.authServiceInterface.service.AuthRestRepository;

@Repository
public class AuthRestRepositoryImpl implements AuthRestRepository {

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public AuthToken validateToken(String token) {
		TokenResponseDto response = restTemplate.getForEntity(
				"http://auth-service/auth/token/" + token, 
				TokenResponseDto.class).getBody();
		
		AuthToken authToken = response.getData();
		return authToken;
	}
}