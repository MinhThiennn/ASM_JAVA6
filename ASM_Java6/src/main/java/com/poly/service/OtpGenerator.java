package com.poly.service;

import java.util.Random;

public class OtpGenerator {
    public static String generateOtp(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder otp = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(numbers.length());
            otp.append(numbers.charAt(index));
        }

        return otp.toString();
    }
}
