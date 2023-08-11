package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.service.CategorySevice;
import com.poly.service.ProductService;


@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategorySevice categorySevice;
	
	@GetMapping("/")
	public String index(Model model) {
		Category cho = categorySevice.findById(10);
		List<Product> choitems = productService.findByCategory(cho);
		model.addAttribute("choitems", choitems);
		
		Category meo = categorySevice.findById(9);
		List<Product> meoitems = productService.findByCategory(meo);
		model.addAttribute("meoitems", meoitems);
		
		return "views/index";
	}
	@GetMapping("/forgotpass")
	public String forgotpass() {
		return "views/forgotpass";
	}
	@GetMapping("/changepass")
	public String changepass() {
		return "views/changepass";
	}
	
	@GetMapping("/gioithieu")
	public String gioithieu() {
		return "views/gioithieu";
	}
	@GetMapping("/chinhsachbaomat")
	public String chinhsachbaomat() {
		return "views/chinhsachbaomat";
	}
	@GetMapping("/chinhsachgiaohang")
	public String chinhsachgiaohang() {
		return "views/chinhsachgiaohang";
	}
	@GetMapping("phuongthucthanhtoan")
	public String phuongthucthanhtoan() {
		return "views/phuongthucthanhtoan";
	}
	@GetMapping("chinhsachdoi-trahang")
	public String chinhsachdoitrahang() {
		return "views/chinhsachdoi-trahang";
	}
	@GetMapping("dieukhoansudung")
	public String dieukhoansudung() {
		return "views/dieukhoansudung";
	}
	@GetMapping("chinhsachhoantien")
	public String chinhsachhoantien() {
		return "views/chinhsachhoantien";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "views/admin";
	}
}
