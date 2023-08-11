package com.poly.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;

@Controller
public class OrderController {
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/order/checkout")
	public String checkout(Model model) {
		String un = request.getRemoteUser();
		Account acc = accountDao.findById(un).get();
		model.addAttribute("acc", acc);
		return "views/checkout";
	}
}
