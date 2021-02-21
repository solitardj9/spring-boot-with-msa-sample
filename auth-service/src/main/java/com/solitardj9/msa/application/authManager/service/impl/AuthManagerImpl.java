package com.solitardj9.msa.application.authManager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solitardj9.msa.application.authManager.model.AuthToken;
import com.solitardj9.msa.application.authManager.service.AuthManager;
import com.solitardj9.msa.application.authManager.service.dao.AuthTokenRepository;
import com.solitardj9.msa.application.authManager.service.dao.dto.AuthTokenDto;
import com.solitardj9.msa.systemInterface.baseServiceInterface.model.User;
import com.solitardj9.msa.systemInterface.baseServiceInterface.service.UserRestRepository;

@Service
public class AuthManagerImpl implements AuthManager {

	@Autowired
	AuthTokenRepository authTokenRepository;
	
	@Autowired
	UserRestRepository userRestRepository;
	
	@Override
	public AuthToken generateAuthToken(String username, String password) {
		User user = userRestRepository.getUserByName(username);
		if(user == null) {
			return null;
		}
		
		String seed = String.valueOf(user.getId()) + user.getUsername() + String.valueOf(System.currentTimeMillis());
		AuthTokenDto authTokenDto = new AuthTokenDto(user.getId(), seed);
		AuthToken result = converAuthTokenDtoToAuthToken(authTokenRepository.saveAndFlush(authTokenDto));
		return result;
	}

	@Override
	public AuthToken getAuthToken(String token) {
		Optional<AuthTokenDto> result = authTokenRepository.findById(token);
		AuthToken authToken = null;
		if(result.isPresent()) {
			authToken = converAuthTokenDtoToAuthToken(result.get());
		}
		return authToken;
	}

	@Override
	public void deleteAuthToken(Long userId) {
		authTokenRepository.deleteByUserId(userId);
	}
	
	@Override
	public User getUserByToken(String token) {
		AuthToken authToken = getAuthToken(token);
		User user = null;
		if(authToken != null) {
			user = userRestRepository.getUserById(authToken.getUserId());
		}
		return user;
	}
	
	private AuthToken converAuthTokenDtoToAuthToken(AuthTokenDto authTokenDto) {
		return new AuthToken(authTokenDto.getToken(), authTokenDto.getUserId(), authTokenDto.getCreatedAt());
	}

	@SuppressWarnings("unused")
	private AuthTokenDto converAuthTokenToAuthTokenDto(AuthToken authToken) {
		return new AuthTokenDto(authToken.getToken(), authToken.getUserId(), authToken.getCreatedAt());
	}
}