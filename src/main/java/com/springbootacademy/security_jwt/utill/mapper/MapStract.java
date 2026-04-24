package com.springbootacademy.security_jwt.utill.mapper;

import com.springbootacademy.security_jwt.dto.RoleDTO;
import com.springbootacademy.security_jwt.dto.SignupRequest;
import com.springbootacademy.security_jwt.dto.UserDTO;
import com.springbootacademy.security_jwt.entity.Role;
import com.springbootacademy.security_jwt.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStract {

    Role RoleDTOToRole(RoleDTO roleDTO);


    User UserDTOToUser(SignupRequest signupRequest);
}
