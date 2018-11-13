package com.cy.bean;
/*采购表*/
public class Purchase {

    private int purchaseId;//采购ID
    private int adminId;//管理员ID
    private String receivedDate;//采购日期
    private  String state;//状态
    private int drugId; //药品ID
    private int drugQuantity;//数量
    private String drugName;//药品品名
    private String adminName;//管理员名
    private float purchasePrice;//采购价格

    public Purchase() {
    }

    public Purchase(int purchaseId, int adminId, String receivedDate, String state, int drugId, int drugQuantity, String drugName, String adminName, float purchasePrice) {
        this.purchaseId = purchaseId;
        this.adminId = adminId;
        this.receivedDate = receivedDate;
        this.state = state;
        this.drugId = drugId;
        this.drugQuantity = drugQuantity;
        this.drugName = drugName;
        this.adminName = adminName;
        this.purchasePrice = purchasePrice;
    }

    public Purchase(int drugQuantity, String drugName) {
        this.drugQuantity=drugQuantity;
        this.drugName=drugName;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
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

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
