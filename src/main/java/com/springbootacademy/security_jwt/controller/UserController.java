package com.springbootacademy.security_jwt.controller;

import com.springbootacademy.security_jwt.dto.UserDTO;
import com.springbootacademy.security_jwt.entity.User;
import com.springbootacademy.security_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@CrossOrigin
@RequestMapping("api/v1/userController")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(
            path = ("/saveUser")
    )
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
        return userDTO;
    }

    @PostConstruct
    public void initUserAndRoles(){
        userService.initRoleAndUser();
    }

    @GetMapping("/for-admin")
    public String forAdmin(){
        return "This URL for admin!";
    }

    @GetMapping("/for-user")
    public String forUser(){
        return "This URL for user!";
    }
}
