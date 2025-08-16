package com.rktech.accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponseDto {
	
	//So this represents what is the API path my client application trying to invoke .
	private String apiPath; 
	
	// So by using this send the error code which type of HttpStatus to the client applications.
	private HttpStatus errorCode;
	
	private String errorMessage;
	
	private LocalDateTime errorTime;

}
