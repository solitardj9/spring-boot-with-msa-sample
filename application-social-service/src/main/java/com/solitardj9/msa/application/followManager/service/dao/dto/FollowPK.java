package com.solitardj9.msa.application.followManager.service.dao.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowPK implements Serializable {

	private static final long serialVersionUID = -8751183812897660461L;

	private Long followeeId;
	
	private Long followerId;
}