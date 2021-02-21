package com.solitardj9.msa.application.messageManager.postManager.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solitardj9.msa.application.messageManager.postManager.service.dao.dto.PostDto;

public interface PostRepository extends JpaRepository<PostDto, Long> {

	List<PostDto> findAllByUserId(Long userId);

	List<PostDto> findByIdInOrderByIdDesc(List<Long> postIdList);
	
	List<PostDto> findAllByOrderByIdDesc();
}