package com.solitardj9.msa.application.followManager.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solitardj9.msa.application.followManager.model.Follow;
import com.solitardj9.msa.application.followManager.service.FollowManager;
import com.solitardj9.msa.application.followManager.service.dao.FollowRepository;
import com.solitardj9.msa.application.followManager.service.dao.dto.FollowDto;

@Service("followManager")
public class FollowManagerImpl implements FollowManager {

	@Autowired
	FollowRepository followRepository;
	
	@Override
	public Follow addFollow(Long followeeId, Long followerId) {
		FollowDto followDto = new FollowDto(followeeId, followerId);
		Follow result = converFollowDtoToFollow(followRepository.saveAndFlush(followDto));
		return result;
	}

	// get list who follow me
	@Override
	public List<Follow> getFollowerList(Long followeeId) {
		List<FollowDto> followDtoList = followRepository.findByFolloweeId(followeeId);
		List<Follow> followList = null;
		
		if (followDtoList != null && !followDtoList.isEmpty()) {
			followList = new ArrayList<>();
			for (FollowDto iter : followDtoList) {
				followList.add(converFollowDtoToFollow(iter));
			}
		}
		return followList;
	}

	@Override
	@Transactional
	public void deleteFollow(Long followeeId, Long followerId) {
		followRepository.deleteByFolloweeIdAndFollowerId(followeeId, followerId);
	}

	// get list who followed by me
	// filterd by some specific followeeId
	@Override
	public List<Follow> getFolloweeList(Long followerId, List<Long> followeeIdList) {

		List<FollowDto> followDtoList = null;
		if (followeeIdList ==null || followeeIdList.isEmpty()) {
			followDtoList = followRepository.findByFollowerId(followerId);
		}
		else {
			followDtoList = followRepository.findByFollowerIdAndFolloweeIdIn(followerId, followeeIdList);
		}
		
		List<Follow> followList = null;
		
		if (followDtoList != null && !followDtoList.isEmpty()) {
			followList = new ArrayList<>();
			for (FollowDto iter : followDtoList) {
				followList.add(converFollowDtoToFollow(iter));
			}
		}
		return followList;
	}
	
	private Follow converFollowDtoToFollow(FollowDto followDto) {
		return new Follow(followDto.getFolloweeId(), followDto.getFollowerId(), followDto.getCreatedAt());
	}

	@SuppressWarnings("unused")
	private FollowDto converFollowToFollowDto(Follow follow) {
		return new FollowDto(follow.getFolloweeId(), follow.getFollowerId(), follow.getCreatedAt());
	}
}