package com.solitardj9.msa.application.messageManager.commentManager.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

	private Long id;
	
	private Long userId;
	
	private Long postId;
	
	private String content;
	
	private Date createdAt;
	
	public Comment(Long userId, Long postId, String content) {
		this.userId = userId;
		this.postId = postId;
		this.content = content;
		this.createdAt = new Date();
	}
}