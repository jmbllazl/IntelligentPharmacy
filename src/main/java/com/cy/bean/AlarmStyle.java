package com.cy.bean;


import org.springframework.stereotype.Service;

/**
 * 报警类型
 *
 **/
@Service
public class AlarmStyle {
    private int alarmStyleId;//报警类型Id
    private String alarmStyleName;//报警类型名字
    private int alarmStyleState;//类型状态（0使用中 1禁用）

    public AlarmStyle() {
    }

    public AlarmStyle(int alarmStyle, String alarmStyleName, int alarmStyleState) {
        this.alarmStyleId = alarmStyleId;
        this.alarmStyleName = alarmStyleName;
        this.alarmStyleState = alarmStyleState;
    }

    public int getAlarmStyleId() {
        return alarmStyleId;
    }

    public void setAlarmStyleId(int alarmStyleId) {
        this.alarmStyleId = alarmStyleId;
    }

    public String getAlarmStyleName() {
        return alarmStyleName;
    }

    public void setAlarmStyleName(String alarmStyleName) {
        this.alarmStyleName = alarmStyleName;
    }

    public int getAlarmStyleState() {
        return alarmStyleState;
    }

    public void setAlarmStyleState(int alarmStyleState) {
        this.alarmStyleState = alarmStyleState;
    }
}
