package com.poly.service;

import java.util.List;

import com.poly.entity.Category;
import com.poly.entity.Product;

public interface ProductService {

	List<Product> findAll();
	Product findById(Integer id);
	
	List<Product> findByCategory(Category category);
	

	List<Product> findByCategoryId(Integer id);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

}
