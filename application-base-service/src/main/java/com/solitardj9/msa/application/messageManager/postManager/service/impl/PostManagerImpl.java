package com.solitardj9.msa.application.messageManager.postManager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.solitardj9.msa.application.messageManager.postManager.model.Post;
import com.solitardj9.msa.application.messageManager.postManager.service.PostManager;
import com.solitardj9.msa.application.messageManager.postManager.service.dao.PostRepository;
import com.solitardj9.msa.application.messageManager.postManager.service.dao.dto.PostDto;
import com.solitardj9.msa.application.userManager.model.User;
import com.solitardj9.msa.application.userManager.service.UserManager;

@Service("postManager")
//@EnableBinding(Source.class)
public class PostManagerImpl implements PostManager {

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserManager userManager;
	
	@Override
	public Post addPost(Long userId, String title, String content) {
		PostDto postDto = new PostDto(userId, title, content);
		User user = userManager.getUserById(userId);
		
		Post result = convertPostDtoToPostWithUser(postRepository.save(postDto), user);
		
		return result;
	}

	@Override
	public Post getPost(Long id) {
		Optional<PostDto> result = postRepository.findById(id);
		Post post = null;
		if(result.isPresent()) {
			PostDto postDto = result.get();
			post = convertPostDtoToPostWithUser(postDto, userManager.getUserById(postDto.getUserId()));
		}
		return post;
	}
	
	@Override
	public List<Post> getPostList() {
		List<PostDto> postDtoList = postRepository.findAllByOrderByIdDesc();
		
		List<Post> postList = null;
		
		if (postDtoList !=null && !postDtoList.isEmpty()) {
			postList = new ArrayList<>();
			
			List<Long> userIdList = postDtoList.stream().map(p -> p.getUserId()).distinct().collect(Collectors.toList());
			List<User> userList = userManager.getUserList(userIdList);
			
			for(PostDto iter: postDtoList) {
				Optional<User> user = userList.stream().filter(u -> u.getId().equals(iter.getUserId())).findFirst();
				if(user.isPresent()) {
					Post post = convertPostDtoToPostWithUser(iter, user.get());
					postList.add(post);
				}
			}
		}
		
		return postList;
	}
	
	@Override
	public List<Post> getPostListByUserId(Long userId) {
		List<PostDto> postDtoList = postRepository.findAllByUserId(userId);
		
		List<Post> postList = null;
		
		if (postDtoList !=null && !postDtoList.isEmpty()) {
			postList = new ArrayList<>();
			User user = userManager.getUserById(userId);
			
			if (user != null) {
				for(PostDto iter: postDtoList) {
					Post post = convertPostDtoToPostWithUser(iter, user);
					postList.add(post);
				}
			}
		}
		
		return postList;
	}

	@SuppressWarnings("unused")
	private Post convertPostDtoToPost(PostDto postDto) {
		return new Post(postDto.getId(), postDto.getUserId(), postDto.getTitle(), postDto.getContent(), postDto.getCreatedAt(), userManager.convertUserDtoToUser(postDto.getUserDto()));
	}
	
	private Post convertPostDtoToPostWithUser(PostDto postDto, User user) {
		return new Post(postDto.getId(), postDto.getUserId(), postDto.getTitle(), postDto.getContent(), postDto.getCreatedAt(), user);
	}
	
	@SuppressWarnings("unused")
	private PostDto convetPostToPostDto(Post post) {
		return new PostDto(post.getId(), post.getUserId(), post.getTitle(), post.getContent(), post.getCreatedAt(), userManager.convertUserToUserDto(post.getUser()));
	}
}
