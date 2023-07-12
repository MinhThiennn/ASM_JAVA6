package com.poly.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AccountController {
	@RequestMapping("forgotpass")
	public String forgotpass() {
		return "forgotpass";
	}
	@RequestMapping("newpass")
	public String newpass() {
		return "newpass";
	}
	@RequestMapping("changepass")
	public String changepass() {
		return "changepass";
	}
}