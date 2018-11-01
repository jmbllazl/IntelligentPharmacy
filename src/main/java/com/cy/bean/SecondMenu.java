package com.cy.bean;

public class SecondMenu {

    private  int  phamacySecondId;//二级菜单ID
    private int  phamacyFiestId;//一级菜单ID
    private String phamacySecondName;//二级菜单名
    private  String phamacySecondUrl;//二级菜单路径

    public SecondMenu() {
    }

    public SecondMenu(int phamacySecondId, int phamacyFiestId, String phamacySecondName, String phamacySecondUrl) {
        this.phamacySecondId = phamacySecondId;
        this.phamacyFiestId = phamacyFiestId;
        this.phamacySecondName = phamacySecondName;
        this.phamacySecondUrl = phamacySecondUrl;
    }

    public int getPhamacySecondId() {
        return phamacySecondId;
    }

    public void setPhamacySecondId(int phamacySecondId) {
        this.phamacySecondId = phamacySecondId;
    }

    public int getPhamacyFiestId() {
        return phamacyFiestId;
    }

    public void setPhamacyFiestId(int phamacyFiestId) {
        this.phamacyFiestId = phamacyFiestId;
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
