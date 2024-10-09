package com.nimap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryContoller {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<?> getAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
		try {
			return ResponseEntity.ok(categoryService.getAllCategories(page,size));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Somthing went Wrong!!");
		}
	}

}
