package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Category;
import com.poly.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{

	List<Product> findByCategory(Category category);
}
