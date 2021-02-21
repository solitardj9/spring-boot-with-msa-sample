package com.solitardj9.msa.application.messageManager.postManager.service;

import java.util.List;

import com.solitardj9.msa.application.messageManager.postManager.model.Post;

public interface PostManager {
	
	public Post addPost(Long userId, String title, String content);
	
	public Post getPost(Long id);
	
	public List<Post> getPostList();
	
	public List<Post> getPostListByUserId(Long userId);
}