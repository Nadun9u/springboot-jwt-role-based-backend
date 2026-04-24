package com.springbootacademy.security_jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class SignupRequest {

    private String username;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String userRole;
}
