package com.solitardj9.msa.application.authManager.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthToken {
	
	private String token;

	private Long userId;
	
	private Date createdAt;
}