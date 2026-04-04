package com.springbootacademy.security_jwt.service;

import com.springbootacademy.security_jwt.dto.RoleDTO;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {


    String createNewRole(RoleDTO roleDTO);
}
