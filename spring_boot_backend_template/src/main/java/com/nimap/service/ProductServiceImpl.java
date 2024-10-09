package com.nimap.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nimap.dao.ProductDao;
import com.nimap.entities.Product;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Page<Product> getAllProducts(int page, int size) {
		
		return productDao.findAll(PageRequest.of(page, size));
	}

}
