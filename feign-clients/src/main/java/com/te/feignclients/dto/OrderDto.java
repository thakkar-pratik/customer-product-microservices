package com.te.feignclients.dto;

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
public class OrderDto {

	private int orderQuantity;

	private double orderAmount;

	private String customerId;

	private String productId;
}
