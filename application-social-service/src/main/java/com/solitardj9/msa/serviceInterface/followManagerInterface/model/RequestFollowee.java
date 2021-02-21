package com.solitardj9.msa.serviceInterface.followManagerInterface.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestFollowee {
	
	private List<Long> followeeIdList;
}