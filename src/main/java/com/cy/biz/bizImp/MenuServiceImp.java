package com.cy.biz.bizImp;

import com.cy.bean.FirstMenu;
import com.cy.bean.SecondMenu;
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

    @Override
    public ArrayList<?> findAllFirst() {
        return menuManage.findAllFirst();
    }

    @Override
    public String findSecondMenuName(int id) {
        return menuManage.findSecondMenuName(id);
    }

    @Override
    public String findSecondMenuUrl(int id) {
        return menuManage.findSecondMenuUrl(id);
    }

    @Override
    public int firstMenuId(String name) {
        return menuManage.firstMenuId(name);
    }

    @Override
    public ArrayList<?> findSecondMenu(int firstMenuId) {
        return menuManage.findSecondMenu(firstMenuId);
    }

    @Override
    public void addFirstMenu( String firstMenuName) {
        menuManage.addFirstMenu(firstMenuName);
    }

    @Override
    public void firstMenuDelete(String firstMenuName) {
        menuManage.firstMenuDelete(firstMenuName);
    }

    @Override
    public void updateFirstMenu(FirstMenu firstMenu) {
        menuManage.updateFirstMenu(firstMenu);
    }

    @Override
    public void addSecondMenu(SecondMenu secondMenu) {
        menuManage.addSecondMenu(secondMenu);
    }

    @Override
    public void secondMenuDelete(String secondMenuName) {
        menuManage.secondMenuDelete(secondMenuName);
    }

    @Override
    public void secondMenuDelete2(int firstMenuId) {
        menuManage.secondMenuDelete2(firstMenuId);
    }




}
