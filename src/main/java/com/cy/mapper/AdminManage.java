package com.cy.mapper;


import com.cy.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("adminMapper")
public interface AdminManage {
    //增加用户
    public int addUser(Admin admin);

    //查询用户
    public Admin checkName(String name);

    //查询登录用户
    public Admin login(Admin admin);

    //查询所有用户
    public abstract ArrayList<?> find();

    //启用用户
    public void stopState(String name);

    //禁用用户
    public void startState(String name);

    //查询某一用户的所有信息
    public abstract ArrayList<?> findadmin(String name);

    //修改用户信息
    public void updateadmin(Admin admin);

    //重置密码
    public void newPassword(String name);

    //管理员删除
    public void userDetele(String name);

    //由用户名查找角色ID
    public int selectRoleId(String name);
    //查询所有的角色
    public List<Role> findAllRole();


    //查询拥有的菜单
    public List<SecondMenu> finOwnMenu(int roleId);

    //查询所有二级菜单
    public List<SecondMenu> findAllSecondMenu();

    //查询所有一级菜单
    public List<FirstMenu> findAllFirstMenu();

    //增加权限
    public int addRoleAuthority(@Param("secondMenuId") int secondMenuId, @Param("roleId") int roleId);


    //角色增加有所权限
    public int addAllRoleAuthority(AllMenu allMenu);

    //删除用户权限
    public int delRoleAuthority(@Param("secondMenuId") int secondMenuId, @Param("roleId") int roleId);
}
