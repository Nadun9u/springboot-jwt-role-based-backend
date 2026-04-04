package com.springbootacademy.security_jwt.controller;

import com.springbootacademy.security_jwt.dto.LoginRequestDto;
import com.springbootacademy.security_jwt.dto.LoginResponseDto;
import com.springbootacademy.security_jwt.service.JwtService;
import com.springbootacademy.security_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/loginController")
public class LoginController {

    @Autowired
    private JwtService jwtService;
    @PostMapping(
            path=("/authentication")
    )
    public LoginResponseDto createJwtTokenAndLogin(@RequestBody LoginRequestDto loginRequestDto) throws Exception{

        System.out.println("createJwtTokenAndLogin");
       return jwtService.createJwtToken(loginRequestDto);

    }

    @PostMapping(
            path = ("/test")
    )
    public String test(){
        return "test";
    }



}
