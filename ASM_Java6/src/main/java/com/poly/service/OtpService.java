package com.poly.service;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;

import java.time.LocalDateTime;

@Service
public class OtpService {
    private final EmailService emailService;
    private final CacheManager cacheManager;
    private final AccountDao accountDao; // Thêm biến accountDao
    


    public OtpService(EmailService emailService, CacheManager cacheManager, AccountDao accountDao) {
        this.emailService = emailService;
        this.cacheManager = cacheManager;
        this.accountDao = accountDao; // Lưu trữ accountDao
    }

    public void sendOtpByEmail(String email) {
        String otp = OtpGenerator.generateOtp(6); // 6-digit OTP
        String subject = "Your OTP Code";
        String text = "Your OTP code is: " + otp;

        emailService.sendOtpEmail(email, subject, text);

        // Lưu mã OTP vào cache với khóa là địa chỉ email
        Cache cache = cacheManager.getCache("otpCache"); // Sử dụng CacheManager đã tiêm vào
        cache.put(email, otp);
    }
    public boolean isEmailExists(String email) {
        Account account = accountDao.findByEmail(email); // Sử dụng bean đã được inject
        return account != null;
    }


    @Cacheable(value = "otpCache", key = "#email")
    public String getOtpByEmail(String email) {
        // Trả về mã OTP từ cache
        Cache cache = cacheManager.getCache("otpCache"); // Sử dụng CacheManager đã tiêm vào
        return cache.get(email, String.class);
    }

    public boolean validateOtp(String email, String enteredOtp) {
        String cachedOtp = getOtpByEmail(email);
        if (cachedOtp != null && cachedOtp.equals(enteredOtp)) {
            LocalDateTime now = LocalDateTime.now();
            // Kiểm tra thời hạn hết hạn của OTP (nếu cần)
            return true; // Trả về true nếu mã OTP hợp lệ
        }
        return false;
    }

    public void resetPassword(String email, String newPassword) {
        
        clearOtpByEmail(email);
    }

    @CacheEvict(value = "otpCache", key = "#email")
    public void clearOtpByEmail(String email) {
       
    }
    
}
