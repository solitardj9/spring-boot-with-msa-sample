package com.solitardj9.msa.serviceInterface.messageManagerInterface.postManagerInterface.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPost {
	
	private String title;
	
	private String content;
}