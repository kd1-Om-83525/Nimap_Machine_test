package com.nimap.service;

import org.springframework.data.domain.Page;

import com.nimap.dto.ApiResponse;
import com.nimap.dto.ProductRequestDTO;
import com.nimap.entities.Product;

public interface ProductService {

	Page<Product> getAllProducts(int page, int size);
	
	ApiResponse createProduct(ProductRequestDTO dto);
	
	ApiResponse updateProduct(Long productId,ProductRequestDTO dto);
	
	Product getById(Long id);
}
