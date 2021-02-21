package com.solitardj9.msa.systemInterface.baseServiceInterface.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
	
	private Integer code;
	
	private String message;
	
	private User data;
}