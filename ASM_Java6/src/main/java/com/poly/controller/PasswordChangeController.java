package com.poly.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Account;
import com.poly.service.AccountService;

@Controller
public class PasswordChangeController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/password-change")
    public String showPasswordChangeForm(Model model) {
        return "/views/changepass"; 
    }

    @PostMapping("/password-change")
    public String processPasswordChangeForm(Model model,
                                            @RequestParam String username, @RequestParam String oldPassword,
                                            @RequestParam String newPassword, @RequestParam String confirmPassword) {
        if (username.isEmpty() || oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            model.addAttribute("usernameError", "Please fill in all fields.");
            return "/views/changepass"; 
        }

        Optional<Account> accountOptional = accountService.getAccountByUsername(username);

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();

            if (!account.getPassword().equals(oldPassword)) {
                model.addAttribute("passwordError", "Incorrect old password.");
                return "/views/changepass"; 
            }

            if (!newPassword.equals(confirmPassword)) {
                model.addAttribute("confirmError", "New password and confirm password do not match.");
                return "/views/changepass"; 
            }

            accountService.updateAccountPassword(account, newPassword);
            model.addAttribute("successMessage", "Password changed successfully.");
            return "redirect:"; 
        }

        model.addAttribute("usernameError", "Username not found.");
        return "/views/changepass"; // Tên template HTML của bạn
    }
}
