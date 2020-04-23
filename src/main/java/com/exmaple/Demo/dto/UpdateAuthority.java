package com.exmaple.Demo.dto;

public class UpdateAuthority {
    private int roleId;
    private String newAuthority;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getNewAuthority() {
        return newAuthority;
    }

    public void setNewAuthority(String newAuthority) {
        this.newAuthority = newAuthority;
    }
}
