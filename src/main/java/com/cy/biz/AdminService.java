package com.cy.biz;

import com.cy.bean.Admin;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AdminService {
    public int addUser(Admin admin);
    public Admin checkName(String name);
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

}
