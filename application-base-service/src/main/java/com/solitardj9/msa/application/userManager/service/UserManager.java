package com.solitardj9.msa.application.userManager.service;

import java.util.List;

import com.solitardj9.msa.application.userManager.model.User;
import com.solitardj9.msa.application.userManager.service.dao.dto.UserDto;

public interface UserManager {

	public User addUser(String username, String password);
	
	public User getUserById(Long id);
	
	public User getUserByName(String username);
	
	public User getUser(String userName, String password);

	public List<User> getUserList(List<Long> userIdList);
	
	public User convertUserDtoToUser(UserDto userDto);

	public UserDto convertUserToUserDto(User user);
}