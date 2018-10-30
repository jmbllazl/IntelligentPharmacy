package com.cy.biz.bizImp;

import com.cy.bean.Admin;
import com.cy.biz.AdminService;
import com.cy.mapper.AdminManage;

import javax.annotation.Resource;
import java.util.List;

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


}
