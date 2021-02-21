package com.solitardj9.msa.systemInterface.authServiceInterface.service;

import com.solitardj9.msa.systemInterface.authServiceInterface.model.AuthToken;

public interface AuthRestRepository {

	public AuthToken validateToken(String token);
}