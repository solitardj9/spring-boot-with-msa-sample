package com.solitardj9.msa.serviceInterface.authManagerInterface.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solitardj9.msa.application.authManager.model.AuthToken;
import com.solitardj9.msa.application.authManager.service.AuthManager;
import com.solitardj9.msa.serviceInterface.authManagerInterface.model.RequestAuthToken;
import com.solitardj9.msa.serviceInterface.common.ResultDto;

@RestController
@RequestMapping(value="/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	AuthManager authManager; 
	
	@PostMapping("/authToken")
	public ResultDto createAuthToken(@RequestBody RequestAuthToken requestAuthToken) {
		AuthToken authToken = authManager.generateAuthToken(requestAuthToken.getUsername(), requestAuthToken.getPassword());
		
		if(authToken == null)
			return new ResultDto(404, "fail", "No Data");	
		return new ResultDto(200, "Success", authToken);
	}
	
	@GetMapping("/authToken")
	public ResultDto getAuthToken(@RequestParam String token) {
		AuthToken authToken = authManager.getAuthToken(token);
		return new ResultDto(200, "OK", authToken);
	}
	
	@GetMapping("/token/{token}")
	public ResultDto validateToken(@RequestParam String token) {
		AuthToken authToken = authManager.getAuthToken(token);
		if (authToken != null)
			return new ResultDto(200, "Success", authToken);
		return new ResultDto(404, "fail", "No Data");
	}
}