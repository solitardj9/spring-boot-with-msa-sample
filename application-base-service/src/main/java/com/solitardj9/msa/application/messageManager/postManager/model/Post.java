package com.solitardj9.msa.application.messageManager.postManager.model;

import java.util.Date;

import com.solitardj9.msa.application.userManager.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

	private Long id;
	
	private Long userId;
	
	private String title;
	
	private String content;
	
	private Date createdAt;
	
	private User user;
	
	public Post(Long userId, String title, String content) {
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.createdAt = new Date();
	}
}