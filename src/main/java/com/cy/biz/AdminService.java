package com.cy.biz;

import com.cy.bean.Admin;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface AdminService {
    public int addUser(Admin admin);
    public Admin checkName(String name);
    public Admin login(Admin admin);
    public int delectUser(int userId);
    public int updateUser(Admin backUser);

}
