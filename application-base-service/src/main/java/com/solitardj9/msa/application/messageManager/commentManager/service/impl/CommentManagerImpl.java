package com.solitardj9.msa.application.messageManager.commentManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solitardj9.msa.application.messageManager.commentManager.model.Comment;
import com.solitardj9.msa.application.messageManager.commentManager.service.CommentManager;
import com.solitardj9.msa.application.messageManager.commentManager.service.dao.CommentRepository;
import com.solitardj9.msa.application.messageManager.commentManager.service.dao.dto.CommentDto;

@Service("commentManager")
public class CommentManagerImpl implements CommentManager {
	
	@Autowired
	CommentRepository commentRepository;

	@Override
	public Comment addComment(Long userId, Long postId, String content) {
		CommentDto commentDto = new CommentDto(userId, postId, content);
		Comment result = convertCommentDtoToComment(commentRepository.saveAndFlush(commentDto));
		return result;
	}

	@Override
	public Comment getComment(Long id) {
		Optional<CommentDto> result = commentRepository.findById(id);
		Comment comment = null;
		if(result.isPresent()) {
			comment = convertCommentDtoToComment(result.get());
		}
		return comment;
	}

	@Override
	public List<Comment> getCommentListByPostId(Long postId) {
		List<CommentDto> commentDtoList = commentRepository.findByPostId(postId);
		List<Comment> commentList = null;
		if (commentDtoList != null && !commentDtoList.isEmpty()) {
			commentList = new ArrayList<>();
			for (CommentDto iter : commentDtoList) {
				commentList.add(convertCommentDtoToComment(iter));
			}
		}
		return commentList;
	}

	@Override
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}

	private Comment convertCommentDtoToComment(CommentDto commentDto) {
		return new Comment(commentDto.getId(), commentDto.getUserId(), commentDto.getPostId(), commentDto.getContent(), commentDto.getCreatedAt());
	}
	
	@SuppressWarnings("unused")
	private CommentDto convertCommentToCommentDto(Comment comment) {
		return new CommentDto(comment.getId(), comment.getUserId(), comment.getPostId(), comment.getContent(), comment.getCreatedAt());
	}
}