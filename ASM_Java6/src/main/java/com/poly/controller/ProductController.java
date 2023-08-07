package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Product;
import com.poly.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("/product/list")
	public String list(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("items",list);
		return "product/list";
	}
}
