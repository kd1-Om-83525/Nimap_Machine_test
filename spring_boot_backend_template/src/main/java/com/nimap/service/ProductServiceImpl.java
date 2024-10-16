package com.nimap.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nimap.dao.CategoryDao;
import com.nimap.dao.ProductDao;
import com.nimap.dto.ApiResponse;
import com.nimap.dto.ProductRequestDTO;
import com.nimap.entities.Category;
import com.nimap.entities.Product;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Page<Product> getAllProducts(int page, int size) {
		
		return productDao.findAll(PageRequest.of(page, size));
	}

	@Override
	public ApiResponse createProduct(ProductRequestDTO dto) {
		Category category=categoryDao.findById(dto.getCategoryId()).orElseThrow(()->new RuntimeException("Category Doesn't Exsist"));
		Product product=mapper.map(dto, Product.class);
		product.setCategory(category);
		Product persistentProduct=productDao.save(product);
		return persistentProduct!=null?new ApiResponse("Product Added successfully!"):new ApiResponse("Something went Wrong");
	}

	@Override
	public ApiResponse updateProduct(Long productId,ProductRequestDTO dto) {
		Product product=productDao.findById(productId).orElseThrow(()->new RuntimeException("Product not found"));
		Category category=categoryDao.findById(dto.getCategoryId()).orElseThrow(()->new RuntimeException("Category does not existst"));
		product.setCategory(category);
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		Product persistentProduct=productDao.save(product);
		return persistentProduct!=null?new ApiResponse("Product Updated Successfully"):new ApiResponse("Something Went Wrong!");
	}

	@Override
	public Product getById(Long id) {
		return productDao.findById(id).orElseThrow(()->new RuntimeException("Product of this id not Found"));
	}

	@Override
	public ApiResponse deleteProductById(Long id) {
		Product product=productDao.findById(id).orElseThrow(()->new RuntimeException("Product not found of this id"));
		product.setCategory(null);
		productDao.delete(product);
		return new ApiResponse("Product deketed successfully");
	}

}
