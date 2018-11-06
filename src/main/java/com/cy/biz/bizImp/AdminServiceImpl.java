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
        Admin adminResult =adminMapper.checkName(name);
        return adminResult;
    }

    @Override
    public Admin login(Admin admin) {
        Admin adminResult =adminMapper.login(admin);
        return adminResult;
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

    @Override
    public void userDetele(String name) {
        adminMapper.userDetele(name);
    }

    @Override
    public int selectRoleId(String name) {
        int adminRoleId=0;
        adminRoleId=adminMapper.selectRoleId(name);
        return adminRoleId;
    }


}
