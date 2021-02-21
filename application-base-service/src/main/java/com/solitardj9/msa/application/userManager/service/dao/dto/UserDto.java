package com.solitardj9.msa.application.userManager.service.dao.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Transient
	private Boolean isFollow;

	public UserDto(String username, String password) {
		this.username = username;
		this.password = password;
		this.createdAt = new Date();
	}
}