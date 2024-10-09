
package com.nimap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nimap.entities.Category;

public interface CategoryService {
	public Page<Category> getAllCategories(int page, int size);
}
