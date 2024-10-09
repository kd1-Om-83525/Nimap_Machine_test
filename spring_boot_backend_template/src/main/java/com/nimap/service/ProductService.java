package com.nimap.service;

import org.springframework.data.domain.Page;

import com.nimap.entities.Product;

public interface ProductService {

	Page<Product> getAllProducts(int page, int size);
}
