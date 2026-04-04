package com.springbootacademy.security_jwt.service;

import com.springbootacademy.security_jwt.dto.LoginRequestDto;
import com.springbootacademy.security_jwt.dto.LoginResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

    LoginResponseDto createJwtToken(LoginRequestDto loginRequestDto) throws Exception;
}
