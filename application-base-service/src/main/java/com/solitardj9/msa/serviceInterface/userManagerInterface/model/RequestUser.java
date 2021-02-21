package com.solitardj9.msa.serviceInterface.userManagerInterface.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUser {
	
	private String username;
	
	private String password;
}