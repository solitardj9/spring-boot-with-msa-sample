package com.solitardj9.msa.application.followManager.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solitardj9.msa.application.followManager.service.dao.dto.FollowDto;
import com.solitardj9.msa.application.followManager.service.dao.dto.FollowPK;

public interface FollowRepository extends JpaRepository<FollowDto, FollowPK> {

	List<FollowDto> findByFolloweeId(Long followeeId);
	
	void deleteByFolloweeIdAndFollowerId(Long followeeId, Long followerId);

	List<FollowDto> findByFollowerId(Long followerId);
	
	List<FollowDto> findByFollowerIdAndFolloweeIdIn(Long followerId, List<Long> userIdList);
}