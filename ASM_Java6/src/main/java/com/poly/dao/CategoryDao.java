package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Category;
import java.util.List;
import java.util.Optional;


public interface CategoryDao extends JpaRepository<Category, Integer>{
//	@Query("SELECT c FROM Category c WHERE c.name LIKE %?1")
//	List<Category> findByLikeNameCategory(String name);
	
    Optional<Category> findById(Integer id);
}
