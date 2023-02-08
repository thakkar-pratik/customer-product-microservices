package com.te.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.te.feignclients.dto.ProductDto;
import com.te.feignclients.response.SuccessResponse;
import com.te.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {
	
	
	private final ProductService productService;
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/")
	public SuccessResponse<String> saveProduct(@RequestBody ProductDto productDto){
		return SuccessResponse.<String>builder()
				.message("Product Saved")
				.data(productService.saveProduct(productDto))
				.build();	
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/{productId}")
	public SuccessResponse<ProductDto> getProduct(@PathVariable String productId){
		return SuccessResponse.<ProductDto>builder()
				.message("Product by Id provided by customer")
				.data(productService.getProduct(productId))
				.build();	
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/")
	public SuccessResponse<List<ProductDto>> getProducts(){
		return SuccessResponse.<List<ProductDto>>builder()
				.message("List of Products are as follows")
				.data(productService.getProducts())
				.build();
	}
	
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@PutMapping("/{productId}")
	public SuccessResponse<ProductDto> reduceQuantity(@PathVariable String productId, @RequestParam int quantity){
		return SuccessResponse.<ProductDto>builder()
				.message("Product quantity reduced")
				.data(productService.reduceQuantity(productId,quantity))
				.build();
	}
}
