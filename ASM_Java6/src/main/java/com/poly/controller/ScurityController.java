package com.poly.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.dao.AccountDao;
import com.poly.dao.CartDAO;
import com.poly.entity.Account;
import com.poly.entity.Cart;

@Controller
public class ScurityController {
	@Autowired
	HttpServletRequest request;
	
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	AccountDao accountDao;
	
	@RequestMapping("/security/login/form")
	public String login(Model model) {
		return "views/login";
	}
	
	@RequestMapping("/security/login/success")
	public String success(Model model) {
		String un = request.getRemoteUser();
		Account acc = accountDao.findById(un).get();
		Cart cart = cartDAO.findByAccountUsername(un);
		if(cart == null) {
			Cart cartt = new Cart();
			cartt.setAccount(acc);
			cartDAO.save(cartt);
		}
		
		if(acc.getActivated()== false) {
			model.addAttribute("message", "Tài khoản của bạn đã bị khóa");
			return "views/login";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/security/login/error")
	public String error(Model model) {
		model.addAttribute("message", "Sai thônng tin đăng nhập");
		return "views/login";
	}
	
	@RequestMapping("/security/login/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message", "Không có quyền truy xuất");
		return "views/login";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logoutsuccess(Model model) {
		return "redirect:/";
	}
	
	
}
