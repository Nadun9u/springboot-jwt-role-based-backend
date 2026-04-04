package com.springbootacademy.security_jwt.controller;

import com.springbootacademy.security_jwt.dto.RoleDTO;
import com.springbootacademy.security_jwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/rolecontroller")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(
        path = ("/saveRole")
    )
    public RoleDTO createRole(@RequestBody RoleDTO roleDTO) {

        String result = roleService.createNewRole(roleDTO);

        return roleDTO;
    }


}
