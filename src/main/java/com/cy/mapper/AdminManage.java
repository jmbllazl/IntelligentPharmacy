package com.cy.mapper;


import com.cy.bean.Admin;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface AdminManage {
    //增加用户
    public int addUser(Admin admin);

    //查询用户
    public Admin checkName(String name);

    //查询登录用户
    public Admin login(Admin admin);

    //删除用户
    public int delectUser(int userId);

    //更新用户
    public int updateUser(Admin backUser);

    //查询所有用户
    public List<Admin> selectAllUsers(Map<String, Object> map);
}
