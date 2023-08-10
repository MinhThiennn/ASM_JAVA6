package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.CategoryDao;
import com.poly.entity.Category;
import com.poly.service.CategoryService;


@Service
public class CategoryServiceImpl2 implements CategoryService{
	@Autowired
	CategoryDao cdao;

	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}	
	
}
