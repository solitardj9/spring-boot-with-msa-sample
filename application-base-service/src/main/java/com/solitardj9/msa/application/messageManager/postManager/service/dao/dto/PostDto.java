package com.solitardj9.msa.application.messageManager.postManager.service.dao.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.solitardj9.msa.application.userManager.service.dao.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Transient
	private UserDto userDto;
	
	public PostDto(Long userId, String title, String content) {
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.createdAt = new Date();
	}
}