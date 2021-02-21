package com.solitardj9.msa.serviceInterface.messageManagerInterface.commentManagerInterface.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestComment {
	
	private Long postId;
	
	private String content;
}