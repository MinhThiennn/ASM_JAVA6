package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class indexControlelr {

	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("gioithieu")
	public String gioithieu() {
		return "gioithieu";
	}
	
	@RequestMapping("chinhsachbaomat")
	public String chinhsachbaomat() {
		return "chinhsachbaomat";
	}
	
	@RequestMapping("chinhsachgiaohang")
	public String chinhsachgiaohang() {
		return "chinhsachgiaohang";
	}
	
	@RequestMapping("phuongthucthanhtoan")
	public String phuongthucthanhtoan() {
		return "phuongthucthanhtoan";
	}
	
	@RequestMapping("chinhsachdoi-trahang")
	public String chinhsachdoitrahang() {
		return "chinhsachdoi-trahang";
	}
	
	@RequestMapping("chinhsachhoantien")
	public String chinhsachhoantien() {
		return "chinhsachhoantien";
	}
	
	@RequestMapping("dieukhoansudung")
	public String dieukhoansudung() {
		return "dieukhoansudung";
	}
	
	@RequestMapping("login")
	public String login() {
		return "login";
	}
}
