package com.cy.bean;


import org.springframework.stereotype.Service;

/**
 * 报警表
 *
 **/
@Service
public class Alarm {
    private int alarmId;//报警Id
    private int alarmStyleId;//报警类型
    private int alarmRole;//报警角色（0药房  1药库）
    private String alarmDetails;//报警详情
    private String alarmDate;//报警日期
    private int alarmState;//报警状态
    private String alarmStyleName;//报警类型名字


    public Alarm() {
    }

    public Alarm(int alarmId, int alarmStyleId, int alarmRole, String alarmDetails, String alarmDate,String alarmStyleName,int alarmState) {
        this.alarmId = alarmId;
        this.alarmStyleId = alarmStyleId;
        this.alarmRole = alarmRole;
        this.alarmDetails = alarmDetails;
        this.alarmDate = alarmDate;
        this.alarmStyleName = alarmStyleName;
        this.alarmState = alarmState;
    }

    public int getAlarmState() {
        return alarmState;
    }

    public void setAlarmState(int alarmState) {
        this.alarmState = alarmState;
    }

    public String getAlarmStyleName() {
        return alarmStyleName;
    }

    public void setAlarmStyleName(String alarmStyleName) {
        this.alarmStyleName = alarmStyleName;
    }


    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
    }

    public int getAlarmStyleId() {
        return alarmStyleId;
    }

    public void setAlarmStyleId(int alarmStyleId) {
        this.alarmStyleId = alarmStyleId;
    }

    public int getAlarmRole() {
        return alarmRole;
    }

    public void setAlarmRole(int alarmRole) {
        this.alarmRole = alarmRole;
    }

    public String getAlarmDetails() {
        return alarmDetails;
    }

    public void setAlarmDetails(String alarmDetails) {
        this.alarmDetails = alarmDetails;
    }

    public String getAlarmDate() {
        return alarmDate;
    }

    public void setAlarmDate(String alarmDate) {
        this.alarmDate = alarmDate;
    }
}
