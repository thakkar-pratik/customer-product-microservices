package com.te.customerservice.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.te.customerservice.exception.CustomerNotFoundException;
import com.te.feignclients.response.ErrorResponse;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({
		CustomerNotFoundException.class
	})
	 public ErrorResponse handler(RuntimeException exception) {
		 return ErrorResponse.builder()
				 .Error(exception.getMessage())
				 .build();
	 }
	
	

}
