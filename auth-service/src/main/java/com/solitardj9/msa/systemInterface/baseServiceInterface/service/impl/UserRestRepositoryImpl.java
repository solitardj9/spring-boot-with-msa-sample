package com.solitardj9.msa.systemInterface.baseServiceInterface.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.solitardj9.msa.systemInterface.baseServiceInterface.model.User;
import com.solitardj9.msa.systemInterface.baseServiceInterface.model.UserResponseDto;
import com.solitardj9.msa.systemInterface.baseServiceInterface.service.UserRestRepository;

@Repository
public class UserRestRepositoryImpl implements UserRestRepository {

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public User getUserById(Long userId) {
		UserResponseDto response = restTemplate.getForEntity(
				"http://application-base-service/base/user/" + userId.toString(), 
				UserResponseDto.class).getBody();
		
		User user = response.getData();
		return user;
	}
	
	@Override
	public User getUserByName(String useranme) {
		UserResponseDto response = restTemplate.getForEntity(
				"http://application-base-service/base/userByName/" + useranme, 
				UserResponseDto.class).getBody();
		
		User user = response.getData();
		return user;
	}
}