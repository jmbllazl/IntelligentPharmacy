package com.cy.bean;


/**
 * 报警类型
 *
 **/
public class AlarmStyle {
    private int AlarmStyle;//报警类型Id
    private String AlarmStyleName;//报警类型名字
    private int AlarmStyleState;//类型状态（0使用中 1禁用）

    public AlarmStyle() {
    }

    public AlarmStyle(int alarmStyle, String alarmStyleName, int alarmStyleState) {
        AlarmStyle = alarmStyle;
        AlarmStyleName = alarmStyleName;
        AlarmStyleState = alarmStyleState;
    }

    public int getAlarmStyle() {
        return AlarmStyle;
    }

    public void setAlarmStyle(int alarmStyle) {
        AlarmStyle = alarmStyle;
    }

    public String getAlarmStyleName() {
        return AlarmStyleName;
    }

    public void setAlarmStyleName(String alarmStyleName) {
        AlarmStyleName = alarmStyleName;
    }

    public int getAlarmStyleState() {
        return AlarmStyleState;
    }

    public void setAlarmStyleState(int alarmStyleState) {
        AlarmStyleState = alarmStyleState;
    }
}
