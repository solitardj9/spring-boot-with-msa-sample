package com.solitardj9.msa.serviceInterface.authManagerInterface.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestAuthToken {
	
	private String username;
	
	private String password;
}