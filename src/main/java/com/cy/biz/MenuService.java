package com.cy.biz;

import java.util.ArrayList;

public interface MenuService {

    //二级菜单查找
    public abstract ArrayList<?> findadmin(int adminRoleId);

    //一级菜单查找
    public String findadminFirst(int id);

    //二级菜单ID查找
    public int secondMenuId(String name);
}
