package com.cy.bean;

public class User {
    private int userId;
    private String userName;
    private int userState;
    private int userAge;
    private String password;
    private int userSex;
    private Long userPhone;
    private int userRole;

    public User() {
    }

    public User(int userId, String userName, int userState, int userAge, String password, int userSex, Long userPhone, int userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userState = userState;
        this.userAge = userAge;
        this.password = password;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userRole = userRole;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
