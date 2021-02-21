package com.solitardj9.msa.application.authManager.service;

import com.solitardj9.msa.application.authManager.model.AuthToken;
import com.solitardj9.msa.systemInterface.baseServiceInterface.model.User;

public interface AuthManager {
	
	public AuthToken generateAuthToken(String username, String password);
	
	public AuthToken getAuthToken(String token);
	
	public void deleteAuthToken(Long userId);
	
	public User getUserByToken(String token);
}