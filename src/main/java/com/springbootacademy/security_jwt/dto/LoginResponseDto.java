package com.springbootacademy.security_jwt.dto;

import com.springbootacademy.security_jwt.entity.User;

public class LoginResponseDto {

    private User user;
    private String jwttoken;

    public LoginResponseDto(String jwttoken, User user) {
        this.jwttoken = jwttoken;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public void setJwttoken(String jwttoken) {
        this.jwttoken = jwttoken;
    }
}
