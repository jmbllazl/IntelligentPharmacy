package com.cy.bean;

import java.math.BigDecimal;

public class DrugStoreOutTable {
    private BigDecimal drugstoreoutid;

    private BigDecimal adminid;

    private String drugstoreoutname;

    private String receivedate;

    private String state;

    private Integer drugquantity;

    private String drugname;

    private String adminname;

    private String outreason;

    public DrugStoreOutTable(BigDecimal drugstoreoutid, BigDecimal adminid, String drugstoreoutname, String receivedate, String state, Integer drugquantity, String drugname, String adminname, String outreason) {
        this.drugstoreoutid = drugstoreoutid;
        this.adminid = adminid;
        this.drugstoreoutname = drugstoreoutname;
        this.receivedate = receivedate;
        this.state = state;
        this.drugquantity = drugquantity;
        this.drugname = drugname;
        this.adminname = adminname;
        this.outreason = outreason;
    }

    public DrugStoreOutTable() {
        super();
    }

    public BigDecimal getDrugstoreoutid() {
        return drugstoreoutid;
    }

    public void setDrugstoreoutid(BigDecimal drugstoreoutid) {
        this.drugstoreoutid = drugstoreoutid;
    }

    public BigDecimal getAdminid() {
        return adminid;
    }

    public void setAdminid(BigDecimal adminid) {
        this.adminid = adminid;
    }

    public String getDrugstoreoutname() {
        return drugstoreoutname;
    }

    public void setDrugstoreoutname(String drugstoreoutname) {
        this.drugstoreoutname = drugstoreoutname == null ? null : drugstoreoutname.trim();
    }

    public String getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(String receivedate) {
        this.receivedate = receivedate == null ? null : receivedate.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getDrugquantity() {
        return drugquantity;
    }

    public void setDrugquantity(Integer drugquantity) {
        this.drugquantity = drugquantity;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname == null ? null : drugname.trim();
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getOutreason() {
        return outreason;
    }

    public void setOutreason(String outreason) {
        this.outreason = outreason == null ? null : outreason.trim();
    }
}