package com.springbootacademy.security_jwt.service.impl;

import com.springbootacademy.security_jwt.dto.RoleDTO;
import com.springbootacademy.security_jwt.entity.Role;
import com.springbootacademy.security_jwt.repo.RoleRepo;
import com.springbootacademy.security_jwt.service.RoleService;
import com.springbootacademy.security_jwt.utill.mapper.MapStract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceIMPL implements RoleService {

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private MapStract mapStract;


    @Override
    public String createNewRole(RoleDTO roleDTO) {

       Role role=  mapStract.RoleDTOToRole(roleDTO);

        roleRepo.save(role);

        return "result added!";
    }
}
