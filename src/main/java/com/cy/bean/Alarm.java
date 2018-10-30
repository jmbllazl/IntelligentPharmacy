package com.cy.bean;


/**
 * 报警表
 *
 **/
public class Alarm {
    private int AlarmId;//报警Id
    private int AlarmStyleId;//报警类型
    private int AlarmRole;//报警角色（0药房  1药库）
    private String AlarmDetails;//报警详情
    private String AlarmDate;//报警日期

    public Alarm() {
    }

    public Alarm(int alarmId, int alarmStyleId, int alarmRole, String alarmDetails, String alarmDate) {
        AlarmId = alarmId;
        AlarmStyleId = alarmStyleId;
        AlarmRole = alarmRole;
        AlarmDetails = alarmDetails;
        AlarmDate = alarmDate;
    }

    public int getAlarmId() {
        return AlarmId;
    }

    public void setAlarmId(int alarmId) {
        AlarmId = alarmId;
    }

    public int getAlarmStyleId() {
        return AlarmStyleId;
    }

    public void setAlarmStyleId(int alarmStyleId) {
        AlarmStyleId = alarmStyleId;
    }

    public int getAlarmRole() {
        return AlarmRole;
    }

    public void setAlarmRole(int alarmRole) {
        AlarmRole = alarmRole;
    }

    public String getAlarmDetails() {
        return AlarmDetails;
    }

    public void setAlarmDetails(String alarmDetails) {
        AlarmDetails = alarmDetails;
    }

    public String getAlarmDate() {
        return AlarmDate;
    }

    public void setAlarmDate(String alarmDate) {
        AlarmDate = alarmDate;
    }
}
