package com.cy.bean;


import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;


public class AllMenu {

    private boolean LAY_CHECKED = false;//复选框
    private int phamacySecondId;//二级菜单ID
    private int phamacyFirstId;//一级菜单ID
    private String phamacySecondName;//二级菜单名
    private String phamacyFirstName;//一级菜单名
    private int[] menuList;//
    private int roleId;//角色Id
    private int state;//角色权限状态1为操作全部,0为操作一个


    public AllMenu() {
    }


    public AllMenu(boolean LAY_CHECKED, int phamacySecondId, int phamacyFirstId, String phamacySecondName, String phamacyFirstName, int[] menuList, int roleId, int state) {
        this.LAY_CHECKED = LAY_CHECKED;
        this.phamacySecondId = phamacySecondId;
        this.phamacyFirstId = phamacyFirstId;
        this.phamacySecondName = phamacySecondName;
        this.phamacyFirstName = phamacyFirstName;
        this.menuList = menuList;
        this.roleId = roleId;
        this.state = state;
    }

    public AllMenu(int phamacySecondId) {
        this.phamacySecondId = phamacySecondId;
    }

    public int getPhamacySecondId() {
        return phamacySecondId;
    }

    public void setPhamacySecondId(int phamacySecondId) {
        this.phamacySecondId = phamacySecondId;
    }

    public int getPhamacyFirstId() {
        return phamacyFirstId;
    }

    public void setPhamacyFirstId(int phamacyFirstId) {
        this.phamacyFirstId = phamacyFirstId;
    }

    public String getPhamacySecondName() {
        return phamacySecondName;
    }

    public void setPhamacySecondName(String phamacySecondName) {
        this.phamacySecondName = phamacySecondName;
    }

    public String getPhamacySecondUrl() {
        return phamacyFirstName;
    }

    public void setPhamacySecondUrl(String phamacySecondUrl) {
        this.phamacyFirstName = phamacySecondUrl;
    }

    public boolean isLAY_CHECKED() {
        return LAY_CHECKED;
    }

    public void setLAY_CHECKED(boolean LAY_CHECKED) {
        this.LAY_CHECKED = LAY_CHECKED;
    }

    public String getPhamacyFirstName() {
        return phamacyFirstName;
    }

    public void setPhamacyFirstName(String phamacyFirstName) {
        this.phamacyFirstName = phamacyFirstName;
    }

    public int[] getMenuList() {
        return menuList;
    }

    public void setMenuList(int[] menuList) {
        this.menuList = menuList;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
