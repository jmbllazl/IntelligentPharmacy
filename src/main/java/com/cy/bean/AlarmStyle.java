package com.cy.bean;


/**
 * 报警类型
 *
 **/
public class AlarmStyle {
    private int alarmStyle;//报警类型Id
    private String alarmStyleName;//报警类型名字
    private int alarmStyleState;//类型状态（0使用中 1禁用）

    public AlarmStyle() {
    }

    public AlarmStyle(int alarmStyle, String alarmStyleName, int alarmStyleState) {
        this.alarmStyle = alarmStyle;
        this.alarmStyleName = alarmStyleName;
        this.alarmStyleState = alarmStyleState;
    }

    public int getAlarmStyle() {
        return alarmStyle;
    }

    public void setAlarmStyle(int alarmStyle) {
        this.alarmStyle = alarmStyle;
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
