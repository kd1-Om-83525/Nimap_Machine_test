package com.nimap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
