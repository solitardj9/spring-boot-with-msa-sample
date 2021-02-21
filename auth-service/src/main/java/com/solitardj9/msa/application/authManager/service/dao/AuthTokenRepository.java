package com.solitardj9.msa.application.authManager.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solitardj9.msa.application.authManager.service.dao.dto.AuthTokenDto;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthTokenDto, String> {

	void deleteByUserId(Long userId);
}