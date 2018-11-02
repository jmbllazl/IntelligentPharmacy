package com.cy.biz;

import com.cy.bean.FirstMenu;

import java.util.ArrayList;

public interface MenuService {

    //二级菜单查找
    public abstract ArrayList<?> findadmin(int adminRoleId);

    //一级菜单查找
    public ArrayList<?> findadminFirst(int id);

    //二级菜单ID查找
    public int secondMenuId(String name);

    //一级菜单查找
    public ArrayList<?> findAllFirst();

    //通过一级菜单ID查找二级菜单名
    public String findSecondMenuName(int id);

    //通过一级菜单ID查找二级菜单地址
    public String findSecondMenuUrl(int id);
}
