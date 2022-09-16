package com.vijays.rewards.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vijays.rewards.exceptions.ErrorResponse;

// Error page mapping to remove White Label error page
// Here it catches all bad URLs. Data issues will be handled by AppController

@RestController
public class AppErrorController implements ErrorController {

	@RequestMapping("/error")
	@ResponseBody
	public ErrorResponse handleError() {
		ErrorResponse errorResponse = new ErrorResponse (HttpStatus.INTERNAL_SERVER_ERROR, "No such API URL") ;
		return errorResponse ;
	}
	
	public String getErrorPath() {
		return "/error";
	}

}