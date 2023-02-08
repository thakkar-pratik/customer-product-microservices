package com.te.productservice.exceptions.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.te.feignclients.response.ErrorResponse;
import com.te.productservice.exceptions.ProductNotFoundException;
import com.te.productservice.exceptions.QuantityException;

@RestControllerAdvice
public class RestResponseEntityException extends ResponseEntityExceptionHandler{
	

	@ExceptionHandler({
		ProductNotFoundException.class,
		QuantityException.class
	})
	 public ErrorResponse handler(RuntimeException exception) {
		 return ErrorResponse.builder()
				 .Error(exception.getMessage())
				 .build();
	 }
}
