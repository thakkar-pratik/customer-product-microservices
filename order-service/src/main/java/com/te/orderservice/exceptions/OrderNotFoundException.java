package com.te.orderservice.exceptions;

@SuppressWarnings("serial")
public class OrderNotFoundException  extends RuntimeException{
	
	public OrderNotFoundException(String message){
		super(message);
	}
	

}
