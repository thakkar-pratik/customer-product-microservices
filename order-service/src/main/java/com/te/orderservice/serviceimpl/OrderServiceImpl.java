package com.te.orderservice.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.te.feignclients.dto.OrderDto;
import com.te.feignclients.dto.ProductDto;
import com.te.feignclients.response.SuccessResponse;
import com.te.orderservice.entity.Order;
import com.te.orderservice.exceptions.OrderNotFoundException;
import com.te.orderservice.repository.OrderRepository;
import com.te.orderservice.service.OrderService;
import com.te.orderservice.service.external.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final RestTemplate restTemplate;
	private final ProductService productService;

	@Override
	public String saveOrder(OrderDto orderDto) {
//		SuccessResponse forObject = restTemplate
//				.getForObject("http://PRODUCT-SERVICE/products/" + orderDto.getProductId() + "?quantity=" + orderDto.getOrderQuantity(), SuccessResponse.class);
//		System.out.println(forObject.getData());

//		SuccessResponse<ProductDto> successResponse = productService.getProduct(orderDto.getProductId());
//		System.out.println(successResponse.getData());
		
		SuccessResponse<ProductDto> successResponse = productService.reduceQuantity(orderDto.getProductId(),orderDto.getOrderQuantity());
		System.out.println(successResponse.getData());
		
		return orderRepository.save(Order.builder()
				.orderQuantity(orderDto.getOrderQuantity()).orderAmount(orderDto.getOrderAmount())
				.customerId(orderDto.getCustomerId()).productId(orderDto.getProductId()).build()).getOrderId();
	}

	@Override
	public OrderDto getOrder(String orderId) {
		return orderRepository.findById(orderId).map(order -> {
			OrderDto orderDto = new OrderDto();
			BeanUtils.copyProperties(order, orderDto);
			return orderDto;
		}).orElseThrow(() -> new OrderNotFoundException("ORDER_WITH_ID_GIVEN_NOT_FOUND"));
	}

	@Override
	public List<OrderDto> getOrders() {
		return orderRepository.findAll().stream().map(order -> {
			OrderDto orderDto = new OrderDto();
			BeanUtils.copyProperties(order, orderDto);
			return orderDto;
		}).collect(Collectors.toList());
	}

}
