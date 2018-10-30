package com.cy.bean;


/**
 * 药房状态表
 *
 **/
public class DrugState {
    private int DrugStateID;//药品状态Id
    private int AdminId;//管理员Id
    private String DrugStateName;//状态用词（使用、报损、停用、滞销、原价、调价）
    private String ReviewDate;//审核日期
    private String ReviewState;//状态（审核中、审核通过、审核不通过）

    public DrugState() {
    }

    public DrugState(int drugStateID, int adminId, String drugStateName, String reviewDate, String reviewState) {
        DrugStateID = drugStateID;
        AdminId = adminId;
        DrugStateName = drugStateName;
        ReviewDate = reviewDate;
        ReviewState = reviewState;
    }

    public int getDrugStateID() {
        return DrugStateID;
    }

    public void setDrugStateID(int drugStateID) {
        DrugStateID = drugStateID;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public String getDrugStateName() {
        return DrugStateName;
    }

    public void setDrugStateName(String drugStateName) {
        DrugStateName = drugStateName;
    }

    public String getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(String reviewDate) {
        ReviewDate = reviewDate;
    }

    public String getReviewState() {
        return ReviewState;
    }

    public void setReviewState(String reviewState) {
        ReviewState = reviewState;
    }
}
