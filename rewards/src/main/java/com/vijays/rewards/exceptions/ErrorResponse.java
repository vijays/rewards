package com.vijays.rewards.exceptions;

import org.springframework.http.HttpStatus;

// Class to capture error details

public class ErrorResponse {

	HttpStatus errorCode ;
	String errorMessage ;
	public ErrorResponse(HttpStatus errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public HttpStatus getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
