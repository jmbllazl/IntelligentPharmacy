package com.cy.biz.bizImp;

import com.cy.bean.FirstMenu;
import com.cy.biz.MenuService;
import com.cy.mapper.MenuManage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class MenuServiceImp implements MenuService {

    @Resource
    MenuManage menuManage;

    //二级菜单查找
    @Override
    public ArrayList<?> findadmin(int adminRoleId) {
        return menuManage.findadmin(adminRoleId);
    }

    //一级菜单查找
    @Override
    public ArrayList<?> findadminFirst(int id) {
        return menuManage.findadminFirst(id);
    }

    //二级菜单ID查找
    @Override
    public int secondMenuId(String name) {
        int secondMenuId=0;
        secondMenuId=menuManage.secondMenuId(name);
        return secondMenuId;
    }
}
