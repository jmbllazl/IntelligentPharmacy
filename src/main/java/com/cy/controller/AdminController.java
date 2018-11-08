package com.cy.controller;

import com.cy.bean.Admin;
import com.cy.bean.FirstMenu;
import com.cy.bean.SecondMenu;
import com.cy.biz.AdminService;
import com.cy.biz.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
import java.util.*;

@Controller
@RequestMapping("/adminPage")
public class AdminController {

    HttpSession session;
    @Resource
    private AdminService adminServiceImpl;
    private ArrayList<Admin> adminList=null;
    @Resource
    private MenuService menuServiceImp;
    private ArrayList<FirstMenu> firstMenuList=null;
    private ArrayList<FirstMenu> firstMenu=new ArrayList<FirstMenu>();
    private ArrayList<Integer> firstId =new ArrayList<Integer> ();
    private ArrayList<SecondMenu> secondMenuList=null;
    @Resource
    private Admin admin;
    public static String adminName=null;


    //强制转换
    public static int toInt(String strNum ){
        Integer integer = new Integer(strNum);
        return integer.parseInt(strNum);
    }

    //登录
    @RequestMapping("/adminLogin")
    public String Login(Model model, Admin admin, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String sessionCode = (String)session.getAttribute("code");
        String code=request.getParameter("code");
        System.out.println(admin.getAdminName());
        System.out.println(admin.getPassword());
        if (code.equalsIgnoreCase(sessionCode)) {
            Admin adminResult = adminServiceImpl.login(admin);
            if (adminResult != null) {
                adminName=admin.getAdminName();
                HttpSession session = request.getSession();
                session.setAttribute("adminList",adminResult);
                session =request.getSession();
                //通过用户名查找角色ID
                int adminRoleId=adminServiceImpl.selectRoleId(admin.getAdminName());
                //清空菜单栏
                secondMenuList=null;
                ArrayList<FirstMenu> AllfirstMenuList=new ArrayList<FirstMenu>();

                //二级菜单加载
                secondMenuList= (ArrayList<SecondMenu>) menuServiceImp.findadmin(adminRoleId);
                //一级菜单加载
                FirstMenu first =new FirstMenu();
                for (int i=0;i<secondMenuList.size();i++){
                    //查找找二级菜单的名字
                    firstId.add( secondMenuList.get(i).getPhamacyFirstId());
                }
                //去重
                HashSet set =new HashSet(firstId);
                firstId.clear();
                firstId.addAll(set);
                for(int j=0;j<firstId.size();j++){
                    firstMenuList= (ArrayList<FirstMenu>) menuServiceImp.findadminFirst(firstId.get(j));
                    AllfirstMenuList.addAll(firstMenuList);
                }
                session.setAttribute("firstMenuList",AllfirstMenuList);
                session.setAttribute("secondMenuList",secondMenuList);
                model.addAttribute("admin", adminResult);
                session.setAttribute("admin", adminResult);
                return "adminPage/index";

            } else {
                return "redirect:/login.jsp";

            }
        } else {
            return "redirect:/login.jsp";
        }


    }
    //主页左边界面显示
    @RequestMapping("/adminLeft.action")
    public String adminLeft(){
        return "/adminPage/left";
    }

    //主页上面界面显示
    @RequestMapping("/adminHead.action")
    public String adminHead(){
        return "/adminPage/head";
    }
    //主页左边界面显示
    @RequestMapping("/adminMain.action")
    public String adminMain(){
        return "/adminPage/main";
    }

    //验证码生成
    @RequestMapping("/userImage")
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

    //账号查重
    @RequestMapping("/checkAdminName")
    @ResponseBody
    public Map checkAdminName(String adminName,HttpServletResponse   response){
        Map<String,Object>checkName =new HashMap<String,Object>();
        Admin adminResult = adminServiceImpl.checkName(adminName);
        if(adminResult!=null){
            checkName.put("success",true);
            checkName.put("message","请输入密码");
            return checkName;
        }else{
            checkName.put("failure",false);
            checkName.put("message","用户不存在");
            return checkName;
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
    @RequestMapping("/startState.action")
    public String startState(HttpServletRequest request,String name){
        adminServiceImpl.startState(name);
        adminList= (ArrayList<Admin>) adminServiceImpl.find();
        request.setAttribute("adminList",adminList);
        return "/adminPage/userManage";
    }

    //用户编辑页面显示
    @RequestMapping("/userEditView.action")
    public String  userEditView(HttpServletRequest request,String name){
        adminList= (ArrayList<Admin>) adminServiceImpl.findadmin(name);
        request.setAttribute("adminList",adminList);
        return  "/adminPage/user_management_edit";
    }

    //用户编辑提交
    @RequestMapping("/userEdit.action")
    public String userEdit(HttpServletRequest request){
        int adminId =toInt(request.getParameter("adminid"));
        String adminName = request.getParameter("adminname");
        String  adminTel =request.getParameter("admintel");
        int adminAge = toInt(request.getParameter("adminage"));
        admin=new Admin(adminName,adminTel,adminAge,adminId);
        adminServiceImpl.updateadmin(admin);
        return "/adminFind.action";
    }

    //重置密码
    @RequestMapping("/newPassword.action")
    public String newPassword(HttpServletRequest request,String name){
        adminServiceImpl.newPassword(name);
        adminList= (ArrayList<Admin>) adminServiceImpl.find();
        request.setAttribute("adminList",adminList);
        return "/adminPage/userManage";
    }

    //管理员删除
    @RequestMapping("/userDetele.action")
    public String userDetele(HttpServletRequest request,String name){
        adminServiceImpl.userDetele(name);
        adminList= (ArrayList<Admin>) adminServiceImpl.find();
        request.setAttribute("adminList",adminList);
        return "/adminPage/userManage";
    }

    //管理员配置菜单
    @RequestMapping("/menuConfig.action")
    public String menuConfig(HttpServletRequest request){
        return "/adminPage/menuManage";
    }

    //查询一级菜单
    @RequestMapping(value="/searchFirstMenu.action")
    public @ResponseBody ArrayList<FirstMenu> searchFirstMenu()  {
        firstMenu= (ArrayList<FirstMenu>) menuServiceImp.findAllFirst();
        return firstMenu;
    }

    //查询二级菜单
    @RequestMapping(value ="/searchSendMenu.action")
    public @ResponseBody ArrayList<SecondMenu> searchSendMenu(String firstMenuName){
        int firstMenuId=menuServiceImp.firstMenuId(firstMenuName);
        secondMenuList= (ArrayList<SecondMenu>) menuServiceImp.findSecondMenu(firstMenuId);
        return secondMenuList;
    }

    //一级菜单添加页面
    @RequestMapping("addFirstMenuView.action")
    public String addFirstMenuView(){
        return "/adminPage/addFirstMenuView";
    }

    //一级菜单添加提交
    @RequestMapping("submitFirstMenu.action")
    public String submitFirstMenu(HttpServletRequest request,String firstName){
        menuServiceImp.addFirstMenu(firstName);
        return "/adminPage/menuManage";
    }

    //一级菜单删除
    @RequestMapping("firstMenuDelete.action")
    public String firstMenuDelete(HttpServletRequest request,String firstMenuName,int firstMenuId){
        menuServiceImp.firstMenuDelete(firstMenuName);
        //一级菜单下的子菜单一起删除
        menuServiceImp.secondMenuDelete2(firstMenuId);

        firstMenu= (ArrayList<FirstMenu>) menuServiceImp.findAllFirst();
        request.setAttribute("firstMenu",firstMenu);
        return "adminPage/editFirstMenuView";
    }

    //一级菜单编辑页面
    @RequestMapping("editFirstMenuView.action")
    public String editFirstMenuView(HttpServletRequest request){
        firstMenu= (ArrayList<FirstMenu>) menuServiceImp.findAllFirst();
        request.setAttribute("firstMenu",firstMenu);
        return "adminPage/editFirstMenuView";
    }

    private  int ufirstMenuId=0;
    //一级菜单修改
    @RequestMapping("editFirstMenu.action")
    public String editFirstMenu(HttpServletRequest request,String firstMenuName,int firstMenuId){
        ufirstMenuId=firstMenuId;
        request.setAttribute("firstMenuName",firstMenuName);
        return "adminPage/updateFirstMenu";
    }

    //一级菜单修改提交(有BUG)
    @RequestMapping("updateFirstMenu.action")
    public String updateFirstMenu(HttpServletRequest request){
        System.out.println("id："+ufirstMenuId);
        String firstMenuName = request.getParameter("firstMenuName");
        FirstMenu first = new FirstMenu(firstMenuName,ufirstMenuId);
        menuServiceImp.updateFirstMenu(first);
        firstMenu= (ArrayList<FirstMenu>) menuServiceImp.findAllFirst();
        request.setAttribute("firstMenu",firstMenu);
        return "adminPage/menuManage";
    }

    //二级菜单添加页面
    @RequestMapping("addSecondMenuView.action")
    public String addSecondMenuView(){
        return "adminPage/addSecondMenuView";
    }

    //二级菜单添加提交
    @RequestMapping("submitSecondMenu.action")
    public String submitSecondMenu(HttpServletRequest request,String secondName,String searchFirstMenu){
        int firstMenuId =menuServiceImp.firstMenuId(searchFirstMenu);
        SecondMenu secondMenu = new SecondMenu(secondName,firstMenuId);
        menuServiceImp.addSecondMenu(secondMenu);
        return "adminPage/menuManage";
    }

    //二级菜单删除
    @RequestMapping("secondMenuDetele.action")
    public String secondMenuDetele(HttpServletRequest request,String searchSendMenu){
        menuServiceImp.secondMenuDelete(searchSendMenu);
        return "adminPage/menuManage";
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public AdminService getAdminServiceImpl() {
        return adminServiceImpl;
    }

    public void setAdminServiceImpl(AdminService adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }
}
