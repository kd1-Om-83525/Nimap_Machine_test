package com.nimap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.dto.ProductRequestDTO;
import com.nimap.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<?> getAllProduct(
			@RequestParam (defaultValue = "0")int page,
			@RequestParam (defaultValue = "10") int size){
		try {
			return ResponseEntity.ok(productService.getAllProducts(page, size));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Somthing went Wrong!!");
		}
	}
	
	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody ProductRequestDTO dto){
		try {
			return ResponseEntity.ok(productService.createProduct(dto));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Somthing went Wrong!!");
		}
	}

}
