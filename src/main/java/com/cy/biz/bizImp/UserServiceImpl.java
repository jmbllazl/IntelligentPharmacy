package com.cy.biz.bizImp;

import com.cy.bean.User;
import com.cy.biz.UserService;
import com.cy.mapper.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserManager userManager;
    @Override
    public User userLogin(User user) {
      User userResult = userManager.userLogin(user);
        return userResult;
    }

    @Override
    public int userRegister(User user) {
        int result =userManager.userRegister(user);
        return result;
    }
    @Override
    public User checkName(String name) {
        User adminResult =userManager.checkName(name);
        return adminResult;
    }

    @Override
    public int setPassword(User user) {
        int result=userManager.setPassword(user);
        return result;
    }



}
