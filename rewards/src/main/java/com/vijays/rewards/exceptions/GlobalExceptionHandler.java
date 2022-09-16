package com.vijays.rewards.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// We find all exception handlers in the app here

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Data not found exception
	
	@ExceptionHandler(CustomerDataNotFoundException.class)
	public ResponseEntity<Object> handleCustomerDataNotFoundException (
			CustomerDataNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()) ;
		return new ResponseEntity<Object> (errorResponse, HttpStatus.NOT_FOUND) ;
	}
	
	// Any other exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllOtherException (
			CustomerDataNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()) ;
		return new ResponseEntity<Object> (errorResponse, HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
}
