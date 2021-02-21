package com.solitardj9.msa.application.messageManager.commentManager.service.dao.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="post_id")
	private Long postId;
	
	@Column(name="content")
	private String content;
	
	@Column(name="created_at")
	private Date createdAt;
	
	public CommentDto(Long userId, Long postId, String content) {
		this.userId = userId;
		this.postId = postId;
		this.content = content;
		this.createdAt = new Date();
	}
}