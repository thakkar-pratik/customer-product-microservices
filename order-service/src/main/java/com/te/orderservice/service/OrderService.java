package com.te.orderservice.service;

import java.util.List;

import com.te.feignclients.dto.OrderDto;

public interface OrderService {

	String saveOrder(OrderDto orderDto);

	OrderDto getOrder(String orderId);

	List<OrderDto> getOrders();

}
