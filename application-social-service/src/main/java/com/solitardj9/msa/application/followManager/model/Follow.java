package com.solitardj9.msa.application.followManager.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow {

	private Long followeeId;

	private Long followerId;
	
	private Date createdAt;
}