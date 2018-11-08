package com.cy.controller;

import com.cy.bean.*;
import com.cy.biz.AlarmService;
import com.cy.biz.PhamacyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/alarm")
public class AlarmController {
    private Map<String,Object> map = new HashMap<>();

    @Autowired
    private AlarmService alarmService;

    @Autowired
    private AlarmStyle alarmStyle;

    @Autowired
    private Alarm alarm;

//药品低限查询
    @RequestMapping("/alarmAllDrugs")
    @ResponseBody
    public Map<String, Object>  alarmNumAllDrugsDrugs(HttpServletRequest request,String num ,String adminName){
        Map<String,Object>alarmPage =new HashMap<String,Object>();
        //查询低限数量药品
        List<PhamacyDrug> alarmPhamacyNumList = alarmService.selectAlarmNum(map);
        if(alarmPhamacyNumList.size()!=0){
            Admin loginAdminList = alarmService.selectRoleName(adminName);
            //报警类型添加数据
            Alarm alarm4 = new Alarm();
            alarm4.setAlarmRole(loginAdminList.getAdminRoleId());
            alarm4.setAlarmStyleId(1);
            alarm4.setAlarmDetails("药品数量已低于限制");
            Boolean flag1 = alarmService.addAlarm(alarm4);
            if(flag1) {
                System.out.println("添加低限报警表成功");
                alarmPage.put("numTrue", true);
                return alarmPage;
            }else {
                return alarmPage;
            }
        }else{
            alarmPage.put("numFalse",false);
            return alarmPage;
        }
    }

    //药库药品低限查询
    @RequestMapping("/alarmDrugStroe")
    @ResponseBody
    public Map<String, Object>  alarmDrugStroe(HttpServletRequest request,String num ,String adminName){
        Map<String,Object>alarmPage =new HashMap<String,Object>();
        //查询低限数量药品
        List<DrugStore> alarmPhamacyNumList = alarmService.selectDrugStoreNum(map);
        if(alarmPhamacyNumList.size()!=0){
            Admin loginAdminList = alarmService.selectRoleName(adminName);
            //报警类型添加数据
            Alarm alarm4 = new Alarm();
            alarm4.setAlarmRole(loginAdminList.getAdminRoleId());
            alarm4.setAlarmStyleId(1);
            alarm4.setAlarmDetails("药品数量已低于限制");
            Boolean flag1 = alarmService.addAlarm(alarm4);
            if(flag1) {
                System.out.println("添加药库低限报警成功");
                alarmPage.put("storeSuss", true);
                return alarmPage;
            }else {
                return alarmPage;
            }
        }else{
            alarmPage.put("storeFalse",false);
            return alarmPage;
        }
    }
    //药品过期报警
    @RequestMapping("/alarmPhamacyDate")
    @ResponseBody
    public Map<String, Object>  alarmPhamacyDate(HttpServletRequest request,String num ,String adminName){
        Map<String,Object>alarmPhamacyDatePage =new HashMap<String,Object>();
        //分页查询低限数量药品
        List<PhamacyDrug> alarmPhamacyDateList = alarmService.selectAlarmExpired(map);
        if(alarmPhamacyDateList.size()!=0){
            Admin loginAdminList = alarmService.selectRoleName(adminName);
            //报警类型添加数据
            Alarm alarm3 = new Alarm();
            alarm3.setAlarmRole(loginAdminList.getAdminRoleId());
            alarm3.setAlarmStyleId(3);
            alarm3.setAlarmDetails("药品日期已过期");
            Boolean flag2 = alarmService.addAlarm(alarm3);

            if(flag2) {
                System.out.println("添加过期报警表成功");
                alarmPhamacyDatePage.put("dateTrue", true);
                return alarmPhamacyDatePage;
            }else {
                return alarmPhamacyDatePage;
            }
        }else{
            alarmPhamacyDatePage.put("dateFalse",false);
            return alarmPhamacyDatePage;
        }
    }

    //药品滞销报警
    @RequestMapping("/alarmUnsalable")
    @ResponseBody
    public Map<String, Object>  alarmUnsalable(HttpServletRequest request,String num ,String adminName){
        Map<String,Object>alarmUnsalablePage =new HashMap<String,Object>();
        List<PhamacyDrug> alarmUnsalable = alarmService.selectAlarmUnsalable(map);
        if(alarmUnsalable.size()!=0){
            Admin loginAdminList = alarmService.selectRoleName(adminName);
            //报警类型添加数据
            Alarm alarm2 = new Alarm();
            alarm2.setAlarmRole(loginAdminList.getAdminRoleId());
            alarm2.setAlarmStyleId(2);
            alarm2.setAlarmDetails("药品超过一个月未售出");
            Boolean flag3 = alarmService.addAlarm(alarm2);
            if(flag3) {
                System.out.println("添加滞销报警表成功");
                alarmUnsalablePage.put("usalable", true);
                return alarmUnsalablePage;
            }else {
                return alarmUnsalablePage;
            }
        }else{
            alarmUnsalablePage.put("usalablefailure",false);
            return alarmUnsalablePage;
        }
    }


    //显示警报消息
    @RequestMapping("/alarmAllList")
    public String alarmAllList(HttpServletRequest request,String pageNum,String alarmRole){
        //分页查询报警数据
            PageInfo drugpage = alarmService.selectAlarmListPageInfo(map, pageNum, 5, alarmRole);
            if (drugpage != null) {
                List<AlarmStyle> alarmStyleShow = alarmService.selectAllStyle();
                request.setAttribute("alarmStyleShowList", alarmStyleShow);
                request.setAttribute("alarmRole", alarmRole);
                HttpSession session = request.getSession();
                session.setAttribute("alarmRoleList", alarmRole);
                session.setAttribute("alarmPageList", drugpage);
                if(alarmRole.contains("4")|| alarmRole.contains("5")){
                    return "/pharmacyPage/alarmAllListStroe";
                }else {
                    return "/pharmacyPage/alarmAllList";
                }
            } else {
                return "error";
            }

    }
    //药品信息提示
    @RequestMapping("/alarmManage")
    public String alarmManage(HttpServletRequest request,int alarmId,int alarmStyleId,String alarmRole,String pageNum){
       //药品低限数据
        if(alarmRole.contains("4")|| alarmRole.contains("5")){
            PageInfo alarmNumPageInfo = alarmService.selectDrugStorePageInfo(map, pageNum, 5);
            request.setAttribute("alarmStyleIdList", alarmStyleId);
            request.setAttribute("alarmIdList", alarmId);
            request.setAttribute("alarmRole", alarmRole);
            request.setAttribute("alarmManageList", alarmNumPageInfo);
            return "pharmacyPage/alarmStroe";
        }
        else {
            if (alarmStyleId == 1) {
                PageInfo alarmNumPageInfo = alarmService.selectAlarmNumPageInfo(map, pageNum, 5);
                request.setAttribute("alarmStyleIdList", alarmStyleId);
                request.setAttribute("alarmIdList", alarmId);
                request.setAttribute("alarmRole", alarmRole);
                request.setAttribute("alarmManageList", alarmNumPageInfo);
                return "pharmacyPage/alarmManage";
            }
            //药品滞销数据
            else if (alarmStyleId == 2) {
                PageInfo alarmNumPageInfo = alarmService.selectAlarmUnsalablePageInfo(map, pageNum, 5);
                request.setAttribute("alarmStyleIdList", alarmStyleId);
                request.setAttribute("alarmIdList", alarmId);
                request.setAttribute("alarmRole", alarmRole);
                request.setAttribute("alarmManageList", alarmNumPageInfo);
                return "pharmacyPage/alarmUnsalable";
            }
            //药品日期数据
            else if (alarmStyleId == 3) {
                PageInfo alarmNumPageInfo = alarmService.selectAlarmExpiredPageInfo(map, pageNum, 5);
                request.setAttribute("alarmStyleIdList", alarmStyleId);
                request.setAttribute("alarmIdList", alarmId);
                request.setAttribute("alarmRole", alarmRole);
                request.setAttribute("alarmManageList", alarmNumPageInfo);
                return "pharmacyPage/alarmManageDate";
            } else {
                return "pharmacyPage/alarmManage";
            }
        }
    }
    //显示警报提示
    @RequestMapping("/alarmTable")
    public String alarmTable(){
        return "/pharmacyPage/alarmTable";
    }

    //更改报警信息状态
    @RequestMapping("/alarmSeeDetails")
    public String alarmSeeDetails(HttpServletRequest request,String pageNum,int alarmId,String alarmRole){
        alarmService.seeDetails(alarmId);
        PageInfo drugpage = alarmService.selectAlarmListPageInfo(map,pageNum,5,alarmRole);
        System.out.println(pageNum);
        if(drugpage!=null) {
            List<AlarmStyle> alarmStyleShow = alarmService.selectAllStyle();
            request.setAttribute("alarmStyleShowList",alarmStyleShow);
            request.setAttribute("alarmRole",alarmRole);
            HttpSession session = request.getSession();
            session.setAttribute("alarmPageList", drugpage);
            if(alarmRole.contains("4")|| alarmRole.contains("5")){
                return "/pharmacyPage/alarmAllListStroe";
            }
            return "/pharmacyPage/alarmAllList";
        } else {
            return "error";
        }
    }
    //显示警报类型
    @RequestMapping("/alarmStyleShow")
    public String alarmStyleShow(HttpServletRequest request){

        List<AlarmStyle> alarmStyleShow = alarmService.selectAllStyle();
        request.setAttribute("alarmStyleShowList",alarmStyleShow);
        return "/pharmacyPage/alarmAllList";
    }
    //ajax 返回页面报警信息
    @RequestMapping("/alarmStyleShowList")
    public String alarmStyleShowList(HttpServletRequest request,String pageNum,String alarmStyleId,String alarmRole){
        System.out.println("alarmRole"+alarmRole);
        //分页查询报警数据
        PageInfo drugpage = alarmService.selectAlarmStyleListPageInfo(map,pageNum,5,alarmStyleId);
        if(drugpage!=null) {
            List<AlarmStyle> alarmStyleShow = alarmService.selectAllStyle();
            request.setAttribute("alarmStyleShowList",alarmStyleShow);
            request.setAttribute("alarmRole",alarmRole);
            request.setAttribute("alarmStyleId",alarmStyleId);
            request.setAttribute("alarmPageList", drugpage);
            //request.setAttribute("alarmServiceShowList",drugpage);
            return "/pharmacyPage/alarmAllListStyle";
        } else {
            return "error";
        }
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
