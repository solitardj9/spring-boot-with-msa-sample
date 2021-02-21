package com.solitardj9.msa.application.userManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solitardj9.msa.application.userManager.model.User;
import com.solitardj9.msa.application.userManager.service.UserManager;
import com.solitardj9.msa.application.userManager.service.dao.UserRepository;
import com.solitardj9.msa.application.userManager.service.dao.dto.UserDto;

@Service("userManager")
public class UserManagerImpl implements UserManager {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(String username, String password) {
		UserDto userDto = new UserDto(username, password);
		User result = convertUserDtoToUser(userRepository.saveAndFlush(userDto));
		return result;
	}

	@Override
	public User getUserById(Long id) {
		Optional<UserDto> result = userRepository.findById(id);
		User user = null;
		if(result.isPresent()) {
			user = convertUserDtoToUser(result.get());
		}
		return user;
	}
	
	@Override
	public User getUserByName(String username) {
		UserDto result = userRepository.findByUsername(username);
		User user = null;
		if(result != null) {
			user = convertUserDtoToUser(result);
		}
		return user;
	}
	
	@Override
	public User getUser(String username, String password) {
		UserDto userDto = userRepository.findByUsernameAndPassword(username, password);
		User user = null;
		if(userDto != null) {
			user = convertUserDtoToUser(userDto);
		}
		return user;
	}

	@Override
	public List<User> getUserList(List<Long> userIdList) {
		List<UserDto> userDtoList = userRepository.findByIdIn(userIdList);
		List<User> userList = null;
		if (userDtoList != null && !userDtoList.isEmpty()) {
			userList = new ArrayList<>();
			for (UserDto iter : userDtoList) {
				userList.add(convertUserDtoToUser(iter));
			}
		}
		return userList;
	}
	
	@Override
	public User convertUserDtoToUser(UserDto userDto) {
		return new User(userDto.getId(), userDto.getUsername(), userDto.getPassword(), userDto.getCreatedAt(), userDto.getIsFollow());
	}
	
	@Override
	public UserDto convertUserToUserDto(User user) {
		return new UserDto(user.getId(), user.getUsername(), user.getPassword(), user.getCreatedAt(), user.getIsFollow());
	}
}
