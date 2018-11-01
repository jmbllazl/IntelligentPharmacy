package com.cy.bean;


/**
 * 药房状态表
 *
 **/
public class DrugState {
    private int drugStateID;//药品状态Id
    private int adminId;//管理员Id
    private String drugStateName;//状态用词（使用、报损、停用、滞销、原价、调价）
    private String reviewDate;//审核日期
    private String reviewState;//状态（审核中、审核通过、审核不通过）

    public DrugState() {
    }

    public DrugState(int drugStateID, int adminId, String drugStateName, String reviewDate, String reviewState) {
        this.drugStateID = drugStateID;
        this.adminId = adminId;
        this.drugStateName = drugStateName;
        this.reviewDate = reviewDate;
        this.reviewState = reviewState;
    }

    public int getDrugStateID() {
        return drugStateID;
    }

    public void setDrugStateID(int drugStateID) {
        this.drugStateID = drugStateID;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getDrugStateName() {
        return drugStateName;
    }

    public void setDrugStateName(String drugStateName) {
        this.drugStateName = drugStateName;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewState() {
        return reviewState;
    }

    public void setReviewState(String reviewState) {
        this.reviewState = reviewState;
    }
}
