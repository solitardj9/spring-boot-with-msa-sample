package com.solitardj9.msa.systemInterface.baseServiceInterface.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Long id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	private Date createdAt;
	
	private Boolean isFollow;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.createdAt = new Date();
	}
}