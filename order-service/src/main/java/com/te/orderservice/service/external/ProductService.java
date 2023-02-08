package com.te.orderservice.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.te.feignclients.dto.ProductDto;
import com.te.feignclients.response.SuccessResponse;

@FeignClient(name="product-service")
public interface ProductService {
	
	@GetMapping("/products/{productId}")
	public SuccessResponse<ProductDto> getProduct(@PathVariable String productId);
	
	@PutMapping("products/{productId}")
	public SuccessResponse<ProductDto> reduceQuantity(@PathVariable String productId, @RequestParam int quantity);

}
