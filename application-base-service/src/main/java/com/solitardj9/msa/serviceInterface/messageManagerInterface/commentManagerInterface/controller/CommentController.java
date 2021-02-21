package com.solitardj9.msa.serviceInterface.messageManagerInterface.commentManagerInterface.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solitardj9.msa.application.messageManager.commentManager.model.Comment;
import com.solitardj9.msa.application.messageManager.commentManager.service.CommentManager;
import com.solitardj9.msa.serviceInterface.common.ResultDto;
import com.solitardj9.msa.serviceInterface.messageManagerInterface.commentManagerInterface.model.RequestComment;
import com.solitardj9.msa.systemInterface.authServiceInterface.model.AuthToken;
import com.solitardj9.msa.systemInterface.authServiceInterface.service.AuthRestRepository;

@RestController
@RequestMapping(value="/base")
@CrossOrigin(origins = "*")
public class CommentController {

	@Autowired
	CommentManager commentManager;
	
	@Autowired
	AuthRestRepository authRestRepository;
	
	@PostMapping("/comment")
	public ResultDto addComment(@RequestBody RequestComment requestComment, @RequestHeader(value="accesstoken") String accesstoken) {
		AuthToken authToken = authRestRepository.validateToken(accesstoken);
		if(authToken == null) {
			return new ResultDto(401, "OK", "Authentication Failed");
		}
		Comment comment = commentManager.addComment(authToken.getUserId(), requestComment.getPostId(), requestComment.getContent());
		return new ResultDto(200, "Success", comment);
	}
	
	@GetMapping("/post/{postId}/comment")
	public ResultDto getCommentList(@PathVariable("postId") String postId, @RequestHeader(value="accesstoken") String accesstoken) {
		AuthToken authToken = authRestRepository.validateToken(accesstoken);
		if(authToken == null) {
			return new ResultDto(401, "OK", "Authentication Failed");
		}
		List<Comment> commentList = commentManager.getCommentListByPostId(Long.valueOf(postId));
		return new ResultDto(200, "Success", commentList);
	}
}