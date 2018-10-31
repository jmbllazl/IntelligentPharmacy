package com.cy.controller;

import com.cy.bean.Admin;
import com.cy.biz.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/adminPage")
public class AdminController {

    HttpSession session;

    @Resource
    private AdminService adminServiceImpl;
    private ArrayList<Admin> adminList=null;
    @Resource
    private Admin admin;


    //强制转换
    public static int toInt(String strNum ){
        Integer integer = new Integer(strNum);
        return integer.parseInt(strNum);
    }

    @RequestMapping("/adminLogin")
    public String Login(Model model, Admin admin, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String sessionCode = (String)session.getAttribute("code");
        String code=request.getParameter("code");
        if (code.equalsIgnoreCase(sessionCode)) {

            Admin adminResult = adminServiceImpl.login(admin);
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
    public String  adminFind(HttpServletRequest request){
        adminList= (ArrayList<Admin>) adminServiceImpl.find();
        request.setAttribute("adminList",adminList);
        return "/adminPage/userManage";
    }
    //禁用操作
    @RequestMapping("/stopState.action")
    public String stopState(HttpServletRequest request,String name){
        adminServiceImpl.stopState(name);
        adminList= (ArrayList<Admin>) adminServiceImpl.find();
        request.setAttribute("adminList",adminList);
        return "/adminPage/userManage";
    }
    //启用操作
    @RequestMapping("startState.action")
    public String startState(HttpServletRequest request,String name){
        System.out.println("启用");
        adminServiceImpl.startState(name);
        adminList= (ArrayList<Admin>) adminServiceImpl.find();
        request.setAttribute("adminList",adminList);
        return "/adminPage/userManage";
    }

    //用户编辑页面显示
    @RequestMapping("userEditView.action")
    public String  userEditView(HttpServletRequest request,String name){
        System.out.println("名字："+name);
        adminList= (ArrayList<Admin>) adminServiceImpl.findadmin(name);
        request.setAttribute("adminList",adminList);
        return  "/adminPage/user_management_edit";
    }

    //用户编辑提交
    @RequestMapping("userEdit.action")
    public String userEdit(HttpServletRequest request){
        int adminid =toInt(request.getParameter("adminid"));
        String adminname = request.getParameter("adminname");
        String  admintel =request.getParameter("admintel");
        int adminage = toInt(request.getParameter("adminage"));
        admin=new Admin(adminname,admintel,adminage,adminid);
        adminServiceImpl.updateadmin(admin);
        adminList= (ArrayList<Admin>) adminServiceImpl.findadmin(adminname);
        request.setAttribute("adminList",adminList);
        return "/adminPage/user_management_editsuccefull";
    }

    //重置密码
    @RequestMapping("newPassword.action")
    public String newPassword(HttpServletRequest request,String name){
        System.out.println("密码");
        adminServiceImpl.newPassword(name);
        adminList= (ArrayList<Admin>) adminServiceImpl.find();
        request.setAttribute("adminList",adminList);
        return "/adminPage/userManage";
    }


    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
