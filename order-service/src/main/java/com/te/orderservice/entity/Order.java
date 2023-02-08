package com.te.orderservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "order")
public class Order{
	
	@Id
	private String orderId;
	
	private int orderQuantity;
	
	private double orderAmount;
	
	private String customerId;
	
	private String productId;
	
	

}
