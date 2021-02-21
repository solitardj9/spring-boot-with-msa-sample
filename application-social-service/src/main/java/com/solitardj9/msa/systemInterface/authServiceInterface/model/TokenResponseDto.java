package com.solitardj9.msa.systemInterface.authServiceInterface.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponseDto {
	
	private Integer code;
	
	private String message;
	
	private AuthToken data;
}