package com.nimap.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nimap.dao.CategoryDao;
import com.nimap.dto.ApiResponse;
import com.nimap.dto.CategoryRequestDTO;
import com.nimap.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Page<Category> getAllCategories(int page,int size) {
		
		return categoryDao.findAll(PageRequest.of(page, size));
	}

	@Override
	public ApiResponse addCategory(CategoryRequestDTO dto) {
		Category c= mapper.map(dto, Category.class);
		Category persistentCategory=categoryDao.save(c);
		return persistentCategory!=null ? new ApiResponse("Category Added Successfully"):new ApiResponse("failed!!");
	}

	@Override
	public Category getById(Long id) {
		return categoryDao.findById(id).orElseThrow(()->new RuntimeException("Category not Found"));
	}

	@Override
	public ApiResponse updateCategory(Long id,CategoryRequestDTO dto) {
		Category category = getById(id);
		category.setName(dto.getName());
		Category persistentCategory=categoryDao.save(category);
		return persistentCategory!=null?new ApiResponse("Category Updated Successfully"):new ApiResponse("Something went Wrong!");
	}

	@Override
	public ApiResponse deleteCategory(Long id) {
		categoryDao.deleteById(id);
		return new ApiResponse("Category deleted SUccessfuly!");
	}

	
}
