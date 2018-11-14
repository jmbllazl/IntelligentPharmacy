package com.cy.mapper;

import com.cy.bean.User;
import org.springframework.stereotype.Repository;

@Repository("userManager")
public interface UserManager {
    //查询前端登入
    public User userLogin(User user);
    //查询前端注册
    public int userRegister(User user);

    public User checkName(String name);
//重置密码
  public  int setPassword(User user);


}
