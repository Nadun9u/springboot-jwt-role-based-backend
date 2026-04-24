package com.springbootacademy.security_jwt.service.impl;

import com.springbootacademy.security_jwt.configuration.JwtAuthenticationEntryPoint;
import com.springbootacademy.security_jwt.dto.LoginRequestDto;
import com.springbootacademy.security_jwt.dto.LoginResponseDto;
import com.springbootacademy.security_jwt.entity.Role;
import com.springbootacademy.security_jwt.entity.User;
import com.springbootacademy.security_jwt.repo.UserRepo;
import com.springbootacademy.security_jwt.service.JwtService;
import com.springbootacademy.security_jwt.utill.JwtUtil;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtServiceIMPL implements JwtService, UserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("2loadUserByUsername");
        User user = userRepo.findById(username).get();

        if(user != null){
            System.out.println("3 user  found"+ user.getUserName());

            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    getAuthority(user)
            );

        }else{
            System.out.println("4 user not found");
            throw new UsernameNotFoundException("User not found"+username);

        }
    }

    @Override
    public LoginResponseDto createJwtToken(LoginRequestDto loginRequestDto) throws Exception {

        System.out.println("1createJwtToken");

        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();

        System.out.println("before authantication");
        authanticate(username,password);
        System.out.println("authanticated");

        UserDetails userDetails = loadUserByUsername(username);
      String newGenarateToken =   jwtUtil.generateToken(userDetails);
        System.out.println("4Token created");
      User user = userRepo.findById(username).get();

      LoginResponseDto loginResponseDto = new LoginResponseDto(
              newGenarateToken,
              user);

      return loginResponseDto;


    }

    private void authanticate(String username, String password) throws Exception {
        try{


            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println("UN PW authentication ok");
        }catch (BadCredentialsException e){
            System.out.println("UN PW authentication wrong");
           throw  new BadCredentialsException("Invalide credentials"+e.getMessage());
        }
    }



    private Set getAuthority(User user){
        Set <SimpleGrantedAuthority> authorities = new HashSet();
        for(Role role: user.getRole()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authorities;

    }


}
