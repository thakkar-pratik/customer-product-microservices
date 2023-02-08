package com.te.orderservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.te.feignclients.dto.OrderDto;
import com.te.feignclients.response.SuccessResponse;
import com.te.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/orders")
@RestController
public class OrderController {

	private final OrderService orderService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(path = "/")
	public SuccessResponse<String> placeOrder(@RequestBody OrderDto orderDto) {
		return SuccessResponse
				.<String>builder()
				.message("Order Created")
				.data(orderService.saveOrder(orderDto))
				.build();
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/{orderId}")
	public SuccessResponse<OrderDto> getOrder(@PathVariable String orderId){
		return SuccessResponse.<OrderDto>builder()
				.message("Order With the provided Id is fetched successfully")
				.data(orderService.getOrder(orderId))
				.build();
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/")
	public SuccessResponse<List<OrderDto>> getOrders(){
		return SuccessResponse.<List<OrderDto>>builder()
				.message("All the orders are fetched successfully")
				.data(orderService.getOrders())
				.build();
	}
}
