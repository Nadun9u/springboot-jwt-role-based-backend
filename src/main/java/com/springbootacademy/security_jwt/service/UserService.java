package com.springbootacademy.security_jwt.service;

import com.springbootacademy.security_jwt.dto.SignupRequest;
import com.springbootacademy.security_jwt.dto.UserDTO;
import com.springbootacademy.security_jwt.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUser(SignupRequest signupRequest);

    void initRoleAndUser();
}
