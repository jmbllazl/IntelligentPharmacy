package com.cy.bean;

/**
 * 药品进出表
 *
 **/
public class Receive {
    private int ReceiveId;//请领Id
    private int AdminId;//管理员Id
    private int UserId;//用户Id
    private String ReceiveDrug;//请领、退库、销售
    private String ReceiveDate;//申请日期
    private String State;//状态（审核中、审核通过、审核不通过）


    public Receive() {
        super();
    }

    public Receive(int receiveId, int adminId, int userId, String receiveDrug, String receiveDate, String state) {
        ReceiveId = receiveId;
        AdminId = adminId;
        UserId = userId;
        ReceiveDrug = receiveDrug;
        ReceiveDate = receiveDate;
        State = state;
    }

    public int getReceiveId() {
        return ReceiveId;
    }

    public void setReceiveId(int receiveId) {
        ReceiveId = receiveId;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getReceiveDrug() {
        return ReceiveDrug;
    }

    public void setReceiveDrug(String receiveDrug) {
        ReceiveDrug = receiveDrug;
    }

    public String getReceiveDate() {
        return ReceiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        ReceiveDate = receiveDate;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
