package com.solitardj9.msa.application.followManager.service;

import java.util.List;

import com.solitardj9.msa.application.followManager.model.Follow;

public interface FollowManager {
	
	public Follow addFollow(Long followeeId, Long followerId);
	
	public List<Follow> getFollowerList(Long followeeId);
	
	public void deleteFollow(Long followeeId, Long followerId);

	public List<Follow> getFolloweeList(Long followerId, List<Long> followeeIdList);
}