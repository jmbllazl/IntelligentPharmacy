package com.cy.bean;

/**
 * @author Juer Whang <br/>
 * - project: CompanyCheckSystem
 * - create: 11:07 2018/10/30
 * - 生成二维码需要的实体类
 **/

public class FiveElements {
    private String name;
    private String gender;
    private String idType;
    private String idno;
    private String mobile;

    public FiveElements() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "FiveElements [name=" + name + ", gender=" + gender + ", idType=" + idType + ", idno=" + idno
                + ", mobile=" + mobile + "]";
    }

}
