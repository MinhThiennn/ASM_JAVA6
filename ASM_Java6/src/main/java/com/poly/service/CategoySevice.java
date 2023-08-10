package com.poly.service;

import java.util.Optional;

import com.poly.entity.Category;

public interface CategoySevice {
//	List<Category> findByLikeNameCategory(String name);

	Optional<Category> findById(Integer id);

	
}
