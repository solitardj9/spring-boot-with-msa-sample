package com.solitardj9.msa.serviceInterface.followManagerInterface.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solitardj9.msa.application.followManager.model.Follow;
import com.solitardj9.msa.application.followManager.service.FollowManager;
import com.solitardj9.msa.serviceInterface.common.ResultDto;
import com.solitardj9.msa.serviceInterface.followManagerInterface.model.RequestFollow;
import com.solitardj9.msa.serviceInterface.followManagerInterface.model.RequestFollowee;
import com.solitardj9.msa.systemInterface.authServiceInterface.model.AuthToken;
import com.solitardj9.msa.systemInterface.authServiceInterface.service.AuthRestRepository;

@RestController
@RequestMapping(value="/social")
@CrossOrigin(origins = "*")
public class FollowController {
	
	@Autowired
	FollowManager followManager;
	
	@Autowired
	AuthRestRepository authRestRepository;
	
	@PostMapping("/follow")
	public ResultDto addFollow(@RequestBody RequestFollow requestFollow, @RequestHeader(value="accesstoken") String accesstoken) {
		AuthToken authToken = authRestRepository.validateToken(accesstoken);
		if(authToken == null) {
			return new ResultDto(401, "OK", "Authentication Failed");
		}
		Follow follow = followManager.addFollow(requestFollow.getFolloweeId(), requestFollow.getFollowerId());
		return new ResultDto(200, "Success", follow);
	}
	
	@DeleteMapping("/follow")
	public ResultDto deleteFollow(@RequestBody RequestFollow requestFollow, @RequestHeader(value="accesstoken") String accesstoken) {
		AuthToken authToken = authRestRepository.validateToken(accesstoken);
		if(authToken == null) {
			return new ResultDto(401, "OK", "Authentication Failed");
		}
		followManager.deleteFollow(requestFollow.getFolloweeId(), requestFollow.getFollowerId());
		return new ResultDto(200, "Success", true);
	}
	
	@GetMapping("/followee/{followeeId}/follower")
	public ResultDto getFollowerList(@PathVariable("followeeId") String followeeId, @RequestHeader(value="accesstoken") String accesstoken) {
		AuthToken authToken = authRestRepository.validateToken(accesstoken);
		if(authToken == null) {
			return new ResultDto(401, "OK", "Authentication Failed");
		}
		List<Follow> followerList = followManager.getFollowerList(Long.valueOf(followeeId));
		return new ResultDto(200, "OK", followerList);
	}
	
	@PostMapping("/follower/{followerId}/followee")
	public ResultDto getFolloweeList(@PathVariable("followerId") String followerId, @RequestHeader(value="accesstoken") String accesstoken, @RequestBody RequestFollowee requestFollowee) {
		AuthToken authToken = authRestRepository.validateToken(accesstoken);
		if(authToken == null) {
			return new ResultDto(401, "OK", "Authentication Failed");
		}
		List<Follow> followList = followManager.getFolloweeList(Long.valueOf(followerId), requestFollowee.getFolloweeIdList());
		return new ResultDto(200, "OK", followList);
	}
}