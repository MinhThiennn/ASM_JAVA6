package com.poly.entity;

import lombok.Data;

@Data
public class ResetPasswordDTO {
    private String email;
    private String otp;
    private String newPassword;
    private String confirmPassword;

    // Constructors, getters, setters, và các phương thức khác
}
