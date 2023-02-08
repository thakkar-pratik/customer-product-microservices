package com.te.productservice.service;

import java.util.List;

import com.te.feignclients.dto.ProductDto;

public interface ProductService {

	String saveProduct(ProductDto productDto);

	ProductDto getProduct(String productId);

	List<ProductDto> getProducts();

	ProductDto reduceQuantity(String productId, int quantity);

}
