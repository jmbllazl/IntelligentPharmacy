package com.cy.biz.bizImp;

import com.cy.bean.Admin;
import com.cy.biz.AdminService;
import com.cy.mapper.AdminManage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminManage adminMapper;
    @Override
    public int addUser(Admin admin) {
        return 0;
    }

    @Override
    public Admin checkName(String name) {
        return null;
    }

    @Override
    public Admin login(Admin admin) {
        Admin adminResult =adminMapper.login(admin);
        return adminResult;
    }

    @Override
    public int delectUser(int userId) {
        return 0;
    }

    @Override
    public int updateUser(Admin backUser) {
        return 0;
    }

    @Override
    public ArrayList<?> find() {
        return adminMapper.find();
    }

    @Override
    public void stopState(String name) {
        adminMapper.stopState(name);
    }

    @Override
    public void startState(String name) {
       adminMapper.startState(name);
    }

    @Override
    public ArrayList<?> findadmin(String name) {
        return adminMapper.findadmin(name);
    }

    @Override
    public void updateadmin(Admin admin) {
       adminMapper.updateadmin(admin);
    }

    @Override
    public void newPassword(String name) {
        adminMapper.newPassword(name);

    }


}
