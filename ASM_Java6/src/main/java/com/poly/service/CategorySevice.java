package com.poly.service;

import java.util.List;

import com.poly.entity.Category;

public interface CategorySevice {
//	List<Category> findByLikeNameCategory(String name);

	Category findById(Integer id);
	
	List<Category> findAll();
}
