package com.cy.controller;

import com.cy.bean.Admin;
import com.cy.biz.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@Controller
@RequestMapping("/adminPage")
public class AdminController {

    HttpSession session;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/adminLogin")
    public String Login(Model model, Admin admin, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String sessionCode = (String)session.getAttribute("code");
        String code=request.getParameter("code");
        if (code.equalsIgnoreCase(sessionCode)) {

            Admin adminResult = adminService.login(admin);
            if (adminResult != null) {
                model.addAttribute("admin", adminResult);
                return "forward:/WEB-INF/adminPage/homepage.jsp";

            } else {
                return "redirect:/login.jsp";

            }
        } else {
            return "redirect:/login.jsp";
        }


    }



    @RequestMapping("/userImage")//验证码生成
    public void Image(HttpServletRequest request, HttpServletResponse response) {
        session =request.getSession();
        try {
            Map<String, BufferedImage> images = com.cy.util.ImageUtil.createImage();
            String keyCode = images.keySet().iterator().next();
            BufferedImage image = images.get(keyCode);
            session.setAttribute("code",keyCode);
            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //后台用户列表显示
    @RequestMapping("/adminFind.action")
    public String  adminFind(){
        System.out.println("进入");
        return "adminPage/userManage.jsp";
    }


    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
}
