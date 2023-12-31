package com.poly.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.CategoryDao;
import com.poly.entity.Category;
import com.poly.service.CategorySevice;

@Service
public class CategoryServiceImpl implements CategorySevice{
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public Category findById(Integer id){
		return categoryDao.findById(id).get();
	}
	
	@Override
	public List<Category> findAll(){
		return categoryDao.findAll();
	}
}
