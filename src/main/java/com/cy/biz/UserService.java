package com.cy.biz;

import com.cy.bean.User;

public interface UserService {

    //查询前端登入
    public User userLogin(User user);
    //查询前端注册
    public int userRegister(User user);
            //账号查重
    public User checkName(String name);
//重置密码
 public  int setPassword(User user);

}
