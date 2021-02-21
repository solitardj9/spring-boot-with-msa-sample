package com.solitardj9.msa.serviceInterface.messageManagerInterface.postManagerInterface.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solitardj9.msa.application.messageManager.commentManager.service.CommentManager;
import com.solitardj9.msa.application.messageManager.postManager.model.Post;
import com.solitardj9.msa.application.messageManager.postManager.service.PostManager;
import com.solitardj9.msa.serviceInterface.common.ResultDto;
import com.solitardj9.msa.serviceInterface.messageManagerInterface.postManagerInterface.model.RequestPost;
import com.solitardj9.msa.systemInterface.authServiceInterface.model.AuthToken;
import com.solitardj9.msa.systemInterface.authServiceInterface.service.AuthRestRepository;

@RestController
@RequestMapping(value="/base")
@CrossOrigin(origins = "*")
public class PostController {
	
	@Autowired
	PostManager postManager;
	
	@Autowired
	CommentManager commentManager;
	
	@Autowired
	AuthRestRepository authRestRepository;
	
	@PostMapping("/post")
	public ResultDto addPost(@RequestBody RequestPost requestPost, @RequestHeader(value="accesstoken") String accesstoken) {	
		AuthToken authToken = authRestRepository.validateToken(accesstoken);
		if(authToken == null) {
			return new ResultDto(401, "fail", "Authentication Failed");
		}
		Post post = postManager.addPost(authToken.getUserId(), requestPost.getTitle(), requestPost.getContent());
		return new ResultDto(200, "Success", post);
	}
	
	@GetMapping("/post")
	public ResultDto getPost(@RequestHeader(value="accesstoken") String accesstoken) {
		AuthToken authToken = authRestRepository.validateToken(accesstoken);
		if(authToken == null) {
			return new ResultDto(401, "fail", "Authentication Failed");
		}
		List<Post> postList = postManager.getPostListByUserId(authToken.getUserId());
		return new ResultDto(200, "Success", postList);
	}
}