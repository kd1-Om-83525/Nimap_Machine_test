
package com.nimap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nimap.dto.ApiResponse;
import com.nimap.dto.CategoryRequestDTO;
import com.nimap.entities.Category;

public interface CategoryService {
	
	Page<Category> getAllCategories(int page, int size);
	
	ApiResponse addCategory(CategoryRequestDTO dto);
	
	Category getById(Long id);
	
	ApiResponse updateCategory(Long id,CategoryRequestDTO dto);

	ApiResponse deleteCategory(Long id);
}
