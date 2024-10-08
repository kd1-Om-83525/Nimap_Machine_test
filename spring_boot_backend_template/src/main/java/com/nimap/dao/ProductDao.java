package com.nimap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

}
