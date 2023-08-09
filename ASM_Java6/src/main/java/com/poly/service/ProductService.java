package com.poly.service;

import java.util.List;
import java.util.Optional;

import com.poly.entity.Category;
import com.poly.entity.Product;

public interface ProductService {

	List<Product> findAll();
	
	List<Product> findByCategory(Optional<Category> cho);


}
