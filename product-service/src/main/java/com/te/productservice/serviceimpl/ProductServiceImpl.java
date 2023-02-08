package com.te.productservice.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.feignclients.dto.ProductDto;
import com.te.productservice.entity.Product;
import com.te.productservice.exceptions.ProductNotFoundException;
import com.te.productservice.exceptions.QuantityException;
import com.te.productservice.repository.ProductRepository;
import com.te.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public String saveProduct(ProductDto productDto) {
		return productRepository.save(Product.builder().productId(UUID.randomUUID().toString())
				.productName(productDto.getProductName()).productPrice(productDto.getProductPrice())
				.productQuantity(productDto.getProductQuantity()).build()).getProductId();
	}

	@Override
	public ProductDto getProduct(String productId) {
		return productRepository.findById(productId).map(product->{
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		return productDto;
		}).orElseThrow(()-> new ProductNotFoundException("PRODUCT_WITH_ID_NOT_FOUND"));
	}

	@Override
	public List<ProductDto> getProducts() {
		return productRepository.findAll().stream().map(product->{
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		return productDto;
		}).collect(Collectors.toList());
	}

	@Override
	public ProductDto reduceQuantity(String productId, int quantity) {
		Product product = productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException("PRODUCT_WITH_ID_NOT_FOUND"));
		if(product.getProductQuantity()>= quantity) {
			product.setProductQuantity(product.getProductQuantity()-quantity);
			productRepository.save(product);
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			return productDto;
		}
		throw new QuantityException("QUANTITY_ENTERED_IS_MORE");
	}
	
	
	

}
