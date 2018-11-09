package com.cy.bean;

/*药品出库表*/
public class DrugStoreOut {

    private int drugStoreOutId;//出库ID
    private int adminId;//管理员ID
    private String drugStoreOutName;//请领、退货
    private String receiveDate;//出库日期
    private  String state;//状态
    private int drugQuantity;//数量
    private String drugName;//药品品名
    private String adminName;//管理员名
    private String outReason;//出库原因

    public DrugStoreOut() {
    }

    public DrugStoreOut(int drugStoreOutId, int adminId, String drugStoreOutName, String receiveDate, String state, int drugQuantity, String drugName, String adminName,String outReason) {
        this.drugStoreOutId = drugStoreOutId;
        this.adminId = adminId;
        this.drugStoreOutName = drugStoreOutName;
        this.receiveDate = receiveDate;
        this.state = state;
        this.drugQuantity = drugQuantity;
        this.drugName = drugName;
        this.adminName = adminName;
        this.outReason=outReason;
    }

    public DrugStoreOut(int drugQuantity, String drugName) {
        this.drugQuantity = drugQuantity;
        this.drugName = drugName;
    }

    public int getDrugStoreOutId() {
        return drugStoreOutId;
    }

    public void setDrugStoreOutId(int drugStoreOutId) {
        this.drugStoreOutId = drugStoreOutId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getDrugStoreOutName() {
        return drugStoreOutName;
    }

    public void setDrugStoreOutName(String drugStoreOutName) {
        this.drugStoreOutName = drugStoreOutName;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getOutReason() {
        return outReason;
    }

    public void setOutReason(String outReason) {
        this.outReason = outReason;
    }
}
