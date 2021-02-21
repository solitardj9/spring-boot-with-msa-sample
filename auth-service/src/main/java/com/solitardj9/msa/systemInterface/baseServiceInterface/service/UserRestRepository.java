package com.solitardj9.msa.systemInterface.baseServiceInterface.service;

import com.solitardj9.msa.systemInterface.baseServiceInterface.model.User;

public interface UserRestRepository {

	public User getUserById(Long userId);
	
	public User getUserByName(String username);
}