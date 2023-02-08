package com.te.productservice.exceptions;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String message) {
		super(message);
	}

}
