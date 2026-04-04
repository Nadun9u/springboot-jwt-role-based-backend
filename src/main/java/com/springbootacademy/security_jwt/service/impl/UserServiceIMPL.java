package com.springbootacademy.security_jwt.service.impl;

import com.springbootacademy.security_jwt.dto.UserDTO;
import com.springbootacademy.security_jwt.entity.Role;
import com.springbootacademy.security_jwt.entity.User;
import com.springbootacademy.security_jwt.repo.RoleRepo;
import com.springbootacademy.security_jwt.repo.UserRepo;
import com.springbootacademy.security_jwt.service.UserService;
import com.springbootacademy.security_jwt.utill.mapper.MapStract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceIMPL implements UserService {


    @Autowired
    private MapStract mapStract;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String createUser(UserDTO userDTO) {

       User user =  mapStract.UserDTOToUser(userDTO);

        userRepo.save(user);

        return "result added!";


    }

    public void initRoleAndUser(){
        Role adminrole = new Role();
        if(!roleRepo.existsById("admin")){
            adminrole.setRoleName("admin");
            adminrole.setRoleDescription("admin role");
            roleRepo.save(adminrole);
        }

        Role userrole = new Role();
        if(!roleRepo.existsById("user")){
            userrole.setRoleName("user");
            userrole.setRoleDescription("user role");
            roleRepo.save(userrole);
        }

        if(!userRepo.existsById("admin123")){
            User user = new User();
            user.setUserName("admin123");
            user.setUserFirstName("Nadun");
            user.setUserLastName("Wijenayaka");
            user.setUserPassword(getEncodedPassword("admin@123"));

            Set<Role> adminroles = new HashSet<>();
            adminroles.add(adminrole);
            user.setRole(adminroles);
            userRepo.save(user);

        }

        if(!userRepo.existsById("user123")){
            User user = new User();
            user.setUserName("user123");
            user.setUserFirstName("Peshani");
            user.setUserLastName("Umodya");
            user.setUserPassword(getEncodedPassword("user@123"));

            Set<Role> userroles = new HashSet<>();
            userroles.add(userrole);
            user.setRole(userroles);
            userRepo.save(user);

        }

    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
