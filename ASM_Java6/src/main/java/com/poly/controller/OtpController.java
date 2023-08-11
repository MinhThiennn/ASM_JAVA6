package com.poly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;
import com.poly.service.OtpService;

@Controller
public class OtpController {

    private final OtpService otpService;
    private final AccountDao accountDao;

    public OtpController(OtpService otpService, AccountDao accountDao) {
        this.otpService = otpService;
        this.accountDao = accountDao;
    }

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "/views/forgotpass";
    }

    @GetMapping("/confirm-otp")
    public String showConfirmOtpForm() {
        return "/views/newpass";
    }

    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam("email") String email, HttpSession session, RedirectAttributes redirectAttributes) {
        // Kiểm tra nếu email rỗng
        if (email.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Email không được để trống");
            return "redirect:/forgot-password";
        }

        // Kiểm tra xem email tồn tại trong SQL hay không
        if (!isEmailExistsInSQL(email)) {
            redirectAttributes.addFlashAttribute("error", "Email không tồn tại trong database");
            return "redirect:/forgot-password";
        }

        // Gọi OtpService để gửi mã OTP qua email
        otpService.sendOtpByEmail(email);

        // Lưu email vào session để truyền qua form newpass
        session.setAttribute("resetPasswordEmail", email);
        return "redirect:/confirm-otp";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("newPassword") String newPassword, HttpSession session, RedirectAttributes redirectAttributes) {
        String email = (String) session.getAttribute("resetPasswordEmail");

        if (!isEmailExistsInSQL(email)) {
            redirectAttributes.addFlashAttribute("error", "Email không tồn tại trong cơ sở dữ liệu");
            return "redirect:/confirm-otp";
        }

        // Thay đổi mật khẩu trong SQL
        resetPasswordAndRemoveOtp(email, newPassword);

        redirectAttributes.addFlashAttribute("successMessage", "Đổi mật khẩu thành công");
        return "redirect:";
    }

    private boolean isEmailExistsInSQL(String email) {
        return otpService.isEmailExists(email);
    }

    private void resetPasswordAndRemoveOtp(String email, String newPassword) {
        Account user = accountDao.findByEmail(email);

        if (user != null) {
            // Update the user's password
            user.setPassword(newPassword);
            accountDao.save(user);

            // Remove the OTP information (You need to implement this)
            removeOtpInformation(email);
        }
    }

    // Implement the logic to remove OTP information for the given email
    private void removeOtpInformation(String email) {
        // Your logic to remove OTP information goes here
    }
}
