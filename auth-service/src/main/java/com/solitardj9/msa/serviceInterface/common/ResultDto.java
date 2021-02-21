package com.solitardj9.msa.serviceInterface.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {
	
	private int code;
	
	private String message;
	
	private Object data;
}