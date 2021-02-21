package com.solitardj9.msa.application.authManager.service.dao.dto;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.solitardj9.msa.utils.securityUtils.EncryptionUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "token")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenDto {
	
	@Id
	@Column(name="token")
	private String token;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="created_at")
	private Date createdAt;
	
	public AuthTokenDto(Long userId, String seed) {
		try {
			this.token = EncryptionUtil.sha256(seed);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		this.userId = userId;
		this.createdAt = new Date();
	}
}