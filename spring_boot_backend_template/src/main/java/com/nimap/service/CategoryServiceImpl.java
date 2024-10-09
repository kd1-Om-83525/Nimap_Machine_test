package com.nimap.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nimap.dao.CategoryDao;
import com.nimap.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Page<Category> getAllCategories(int page,int size) {
		
		return categoryDao.findAll(PageRequest.of(page, size));
	}
	
}
