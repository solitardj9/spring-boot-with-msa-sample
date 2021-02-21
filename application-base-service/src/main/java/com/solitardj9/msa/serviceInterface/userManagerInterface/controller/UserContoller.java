package com.solitardj9.msa.serviceInterface.userManagerInterface.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solitardj9.msa.application.userManager.model.User;
import com.solitardj9.msa.application.userManager.service.UserManager;
import com.solitardj9.msa.serviceInterface.common.ResultDto;
import com.solitardj9.msa.serviceInterface.userManagerInterface.model.RequestUser;

@RestController
@RequestMapping(value="/base")
@CrossOrigin(origins = "*")
public class UserContoller {

	@Autowired
	UserManager userManager;
	
	@PostMapping("/user")
	public ResultDto signUp(@RequestBody RequestUser requestUser) {		
		User user = userManager.addUser(requestUser.getUsername(), requestUser.getPassword());
		return new ResultDto(200, "Success", user);
	}
	
	@GetMapping("/user/{userId}")
	public ResultDto getUserById(@PathVariable("userId") String userId) {
		User user = userManager.getUserById(Long.valueOf(userId));
		return new ResultDto(200, "Success", user);
	}
	
	@GetMapping("/userByName/{username}")
	public ResultDto getUserByName(@PathVariable("username") String username) {
		User user = userManager.getUserByName(username);
		return new ResultDto(200, "Success", user);
	}
}