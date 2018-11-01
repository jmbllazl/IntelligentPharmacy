package com.cy.bean;

import org.springframework.stereotype.Service;

@Service
public class FirstMenu {

    private int  phamacyFirstId;//一级菜单ID
    private  String  phamacyFirstName;//一级菜单名

    public FirstMenu() {
    }

    public FirstMenu(int phamacyFirstId, String phamacyFirstName) {
        this.phamacyFirstId = phamacyFirstId;
        this.phamacyFirstName = phamacyFirstName;
    }

    public FirstMenu(String phamacyFirstName) {
        this.phamacyFirstName = phamacyFirstName;
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
}
