package com.solitardj9.msa.application.userManager.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solitardj9.msa.application.userManager.service.dao.dto.UserDto;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {

	UserDto findByUsernameAndPassword(String username, String password);
	
	UserDto findByUsername(String username);

	List<UserDto> findByIdIn(List<Long> userIdList);
}