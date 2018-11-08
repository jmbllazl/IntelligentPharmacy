package com.cy.bean;

public class SecondMenu {

    private  int  phamacySecondId;//二级菜单ID
    private int  phamacyFirstId;//一级菜单ID
    private String phamacySecondName;//二级菜单名
    private  String phamacySecondUrl;//二级菜单路径

    public SecondMenu() {
    }

    public SecondMenu(int phamacySecondId, int phamacyFirstId, String phamacySecondName, String phamacySecondUrl) {
        this.phamacySecondId = phamacySecondId;
        this.phamacyFirstId = phamacyFirstId;
        this.phamacySecondName = phamacySecondName;
        this.phamacySecondUrl = phamacySecondUrl;
    }

    public SecondMenu(int phamacySecondId) {
        this.phamacySecondId = phamacySecondId;
    }

    public SecondMenu(String phamacySecondName,int phamacyFirstId){
        this.phamacySecondName = phamacySecondName;
        this.phamacyFirstId = phamacyFirstId;
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
        return phamacySecondUrl;
    }

    public void setPhamacySecondUrl(String phamacySecondUrl) {
        this.phamacySecondUrl = phamacySecondUrl;
    }
}
