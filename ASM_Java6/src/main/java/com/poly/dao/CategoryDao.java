package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Category;


public interface CategoryDao extends JpaRepository<Category, Integer>{
//	@Query("SELECT c FROM Category c WHERE c.name LIKE %?1")
//	List<Category> findByLikeNameCategory(String name);
	
}
