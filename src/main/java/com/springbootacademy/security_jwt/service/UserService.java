package com.springbootacademy.security_jwt.service;

import com.springbootacademy.security_jwt.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String createUser(UserDTO userDTO);

    void initRoleAndUser();
}
