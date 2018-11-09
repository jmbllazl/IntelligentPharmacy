package com.cy.biz;

import com.cy.bean.FirstMenu;
import com.cy.bean.SecondMenu;

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

    //通过一级菜单名字查找一级菜单的ID
    public int firstMenuId(String name);

    //通过一级菜单ID查找其所有的二级菜单
    public abstract ArrayList<?> findSecondMenu(int firstMenuId);

    //添加一级菜单
    public void addFirstMenu(String firstMenuName);

    //删除一级菜单
    public void firstMenuDelete(String firstMenuName);

    //修改一级菜单
    public void updateFirstMenu(FirstMenu firstMenu);

    //添加二级菜单
    public void addSecondMenu(SecondMenu secondMenu);

    //删除二级菜单
    public void secondMenuDelete(String secondMenuName);

    //删除一级菜单的同时删除二级子菜单
    public void secondMenuDelete2(int firstMenuId);
}
