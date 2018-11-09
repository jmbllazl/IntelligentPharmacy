package com.cy.bean;

import org.springframework.stereotype.Service;

@Service
public class FirstMenu {

    private int  phamacyFirstId;//一级菜单ID
    private  String  phamacyFirstName;//一级菜单名
    private String phamacySecondName;//二级菜单名
    private String phamacySecondUrl;//二级菜单路径

    public FirstMenu() {
    }

    public FirstMenu(int phamacyFirstId, String phamacyFirstName) {
        this.phamacyFirstId = phamacyFirstId;
        this.phamacyFirstName = phamacyFirstName;
    }

    public FirstMenu(String phamacyFirstName) {
        this.phamacyFirstName = phamacyFirstName;
    }

    public FirstMenu( String phamacyFirstName,int phamacyFirstId) {
        this.phamacyFirstName = phamacyFirstName;
        this.phamacyFirstId = phamacyFirstId;
    }

    public int getPhamacyFirstId() {
        return phamacyFirstId;
    }

    public void setPhamacyFirstId(int phamacyFirstId) {
        this.phamacyFirstId = phamacyFirstId;
    }

    public String getPhamacyFirstName() {
        return phamacyFirstName;
    }

    public void setPhamacyFirstName(String phamacyFirstName) {
        this.phamacyFirstName = phamacyFirstName;
    }

    public String getPhamacySecondName() {
        return phamacySecondName;
    }

    public void setPhamacySecondName(String phamacySecondName) {
        this.phamacySecondName = phamacySecondName;
    }

    public String getPhamacySecondUrl() {
        return phamacySecondUrl;
    }

    public void setPhamacySecondUrl(String phamacySecondUrl) {
        this.phamacySecondUrl = phamacySecondUrl;
    }
}
