package com.te.productservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

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
@Entity
public class Product {
	
	@Id
	private String productId;
	
	private String productName;
	
	private int productQuantity;
	
	private double productPrice;

}
