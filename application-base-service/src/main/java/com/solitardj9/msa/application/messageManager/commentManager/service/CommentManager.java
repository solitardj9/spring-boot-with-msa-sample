package com.solitardj9.msa.application.messageManager.commentManager.service;

import java.util.List;

import com.solitardj9.msa.application.messageManager.commentManager.model.Comment;

public interface CommentManager {

	public Comment addComment(Long userId, Long postId, String content);
	
	public Comment getComment(Long id);
	
	public List<Comment> getCommentListByPostId(Long postId);
	
	public void deleteComment(Long id);
}
