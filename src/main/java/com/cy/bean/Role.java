package com.cy.bean;

public class Role {
    private int adminRoleId;
    private String adminRoleName;
    private String adminRoleState;


    public Role() {
    }

    public Role(int adminRoleId, String adminRoleName, String adminRoleState) {
        this.adminRoleId = adminRoleId;
        this.adminRoleName = adminRoleName;
        this.adminRoleState = adminRoleState;

    }

    public int getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(int adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public String getAdminRoleName() {
        return adminRoleName;
    }

    public void setAdminRoleName(String adminRoleName) {
        this.adminRoleName = adminRoleName;
    }

    public String getAdminRoleState() {
        return adminRoleState;
    }

    public void setAdminRoleState(String adminRoleState) {
        this.adminRoleState = adminRoleState;
    }

}
