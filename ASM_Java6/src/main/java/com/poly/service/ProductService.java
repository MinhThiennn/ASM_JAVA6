package com.poly.service;

import java.util.List;
import java.util.Optional;

import com.poly.entity.Category;
import com.poly.entity.Product;

public interface ProductService {

	List<Product> findAll();
	Product findById(Integer id);
	
	List<Product> findByCategory(Optional<Category> cho);

	List<Product> findByCategoryId(Integer id);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

}
