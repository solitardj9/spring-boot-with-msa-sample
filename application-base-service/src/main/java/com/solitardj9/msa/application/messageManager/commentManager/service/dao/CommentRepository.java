package com.solitardj9.msa.application.messageManager.commentManager.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solitardj9.msa.application.messageManager.commentManager.service.dao.dto.CommentDto;

@Repository
public interface CommentRepository extends JpaRepository<CommentDto, Long> {

	List<CommentDto> findByPostId(Long postId);
}