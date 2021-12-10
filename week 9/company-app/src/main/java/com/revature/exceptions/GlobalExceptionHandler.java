package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Invalid credentials")
	@ExceptionHandler(LoginException.class)
	public void handleLoginException() {
		
	}
}
