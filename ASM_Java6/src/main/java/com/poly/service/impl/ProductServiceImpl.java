package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.ProductDAO;
import com.poly.entity.Product;
import com.poly.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
@Autowired
ProductDAO pdao;

@Override
public List<Product> findAll() {
	// TODO Auto-generated method stub
	return pdao.findAll();
}
}
