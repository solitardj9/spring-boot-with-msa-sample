package com.solitardj9.msa.serviceInterface.followManagerInterface.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestFollow {
	
	private Long followeeId;

	private Long followerId;
}