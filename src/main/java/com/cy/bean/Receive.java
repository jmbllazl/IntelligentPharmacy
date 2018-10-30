package com.cy.bean;

/**
 * 药品进出表
 *
 **/
public class Receive {
    private int receiveId;//请领Id
    private int adminId;//管理员Id
    private int userId;//用户Id
    private String receiveDrug;//请领、退库、销售
    private String receiveDate;//申请日期
    private String state;//状态（审核中、审核通过、审核不通过）


    public Receive() {
        super();
    }

    public Receive(int receiveId, int adminId, int userId, String receiveDrug, String receiveDate, String state) {
        this.receiveId = receiveId;
        this.adminId = adminId;
        this.userId = userId;
        this.receiveDrug = receiveDrug;
        this.receiveDate = receiveDate;
        this.state = state;
    }

    public int getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(int receiveId) {
        this.receiveId = receiveId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReceiveDrug() {
        return receiveDrug;
    }

    public void setReceiveDrug(String receiveDrug) {
        this.receiveDrug = receiveDrug;
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
}
