package com.nimap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.dto.CategoryRequestDTO;
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
	
	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody CategoryRequestDTO dto){
		try {
			return ResponseEntity.ok(categoryService.addCategory(dto));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Somthing went Wrong!!");
		}
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(categoryService.getById(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Somthing went Wrong!!");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategoryById(@PathVariable Long id,@RequestBody CategoryRequestDTO dto){
		try {
			return ResponseEntity.ok(categoryService.updateCategory(id,dto));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Somthing went Wrong!!");
		}
	}
	
}
