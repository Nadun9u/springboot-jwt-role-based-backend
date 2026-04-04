package com.springbootacademy.security_jwt.dto;

public class RoleDTO {

    private String roleName;
    private String roleDescription;

    public RoleDTO() {
    }

    public RoleDTO(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
