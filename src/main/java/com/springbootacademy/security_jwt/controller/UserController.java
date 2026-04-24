package com.springbootacademy.security_jwt.controller;

import com.springbootacademy.security_jwt.dto.SignupRequest;
import com.springbootacademy.security_jwt.dto.UserDTO;
import com.springbootacademy.security_jwt.entity.User;
import com.springbootacademy.security_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@CrossOrigin
@RequestMapping("api/v1/userController")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(
            path = ("/register-new-user")
    )
    public User createUser(@RequestBody SignupRequest signupRequest){
        return  userService.createUser(signupRequest);

    }

    @PostConstruct
    public void initUserAndRoles(){
        userService.initRoleAndUser();
    }


    @GetMapping("/for-admin")
    @PreAuthorize("hasRole('admin')")
    public String forAdmin(){
        return "This URL for admin!";
    }


    @GetMapping("/for-user")
    @PreAuthorize("hasAnyRole('user','admin')")
    public String forUser(){
        return "This URL for user!";
    }
}
