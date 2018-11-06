package com.cy.controller;

import com.cy.bean.Admin;
import com.cy.bean.Alarm;
import com.cy.bean.PhamacyDrug;
import com.cy.biz.AlarmService;
import com.cy.biz.PhamacyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private Alarm alarm;

//药品低限查询
    @RequestMapping("/alarmAllDrugs")
    @ResponseBody
    public Map<String, Object>  alarmNumAllDrugsDrugs(HttpServletRequest request,String num ,String adminName){
        Map<String,Object>alarmPage =new HashMap<String,Object>();
        //查询低限数量药品
        List<PhamacyDrug> alarmPhamacyNumList = alarmService.selectAlarmNum(map);
        if(alarmPhamacyNumList!=null){
            Admin loginAdminList = alarmService.selectRoleName(adminName);
            //报警类型添加数据
            alarm.setAlarmRole(loginAdminList.getAdminRoleId());
            alarm.setAlarmStyleId(1);
            alarm.setAlarmDetails("药品数量已低于限制");
            Boolean flag = alarmService.addAlarm(alarm);
            if(flag) {
                System.out.println("添加报警表成功");
                alarmPage.put("success", true);
                return alarmPage;
            }else {
                return alarmPage;
            }
        }else{
            alarmPage.put("failure",false);
            return alarmPage;
        }
    }
    //药品过期报警
    @RequestMapping("/alarmPhamacyDate")
    @ResponseBody
    public Map<String, Object>  alarmPhamacyDate(HttpServletRequest request,String num ,String adminName){
        Map<String,Object>alarmPage =new HashMap<String,Object>();
        //分页查询低限数量药品
        List<PhamacyDrug> alarmPhamacyDateList = alarmService.selectAlarmExpired(map);
        if(alarmPhamacyDateList!=null){
            Admin loginAdminList = alarmService.selectRoleName(adminName);
            //报警类型添加数据
            alarm.setAlarmRole(loginAdminList.getAdminRoleId());
            alarm.setAlarmStyleId(3);
            alarm.setAlarmDetails("药品日期已过期");
            Boolean flag = alarmService.addAlarm(alarm);
            if(flag) {
                System.out.println("添加过期报警表成功");
                alarmPage.put("success", true);
                return alarmPage;
            }else {
                return alarmPage;
            }
        }else{
            alarmPage.put("failure",false);
            return alarmPage;
        }
    }


    //显示警报消息
    @RequestMapping("/alarmAllList")
    public String alarmAllList(HttpServletRequest request,String pageNum){
        //分页查询报警数据
        PageInfo drugpage = alarmService.selectAlarmListPageInfo(map,pageNum,5);
        if(drugpage!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("alarmPageList", drugpage);
            return "/pharmacyPage/alarmAllList";
        } else {
            return "error";
        }
    }
    //药品信息提示
    @RequestMapping("/alarmManage")
    public String alarmManage(HttpServletRequest request,int alarmId,int alarmStyleId,String pageNum){
       //药品低限数据
        if(alarmStyleId==1){
            PageInfo alarmNumPageInfo = alarmService.selectAlarmNumPageInfo(map,pageNum,5);
            request.setAttribute("alarmStyleIdList",alarmStyleId);
            request.setAttribute("alarmIdList",alarmId);
            request.setAttribute("alarmManageList",alarmNumPageInfo);
            return "pharmacyPage/alarmManage";
        }
        //药品日期数据
        else if(alarmStyleId==3){
            PageInfo alarmNumPageInfo = alarmService.selectAlarmExpiredPageInfo(map,pageNum,5);
            request.setAttribute("alarmStyleIdList",alarmStyleId);
            request.setAttribute("alarmIdList",alarmId);
            request.setAttribute("alarmManageList",alarmNumPageInfo);
            return "pharmacyPage/alarmManageDate";
        }
        else{
            return "pharmacyPage/alarmManage";
        }
    }
    //显示警报提示
    @RequestMapping("/alarmTable")
    public String alarmTable(){
        return "/pharmacyPage/alarmTable";
    }

    //更改报警信息状态
    @RequestMapping("/alarmSeeDetails")
    public String alarmSeeDetails(HttpServletRequest request,String pageNum,int alarmId){
        alarmService.seeDetails(alarmId);
        PageInfo drugpage = alarmService.selectAlarmListPageInfo(map,pageNum,5);
        System.out.println(pageNum);
        if(drugpage!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("alarmPageList", drugpage);
            return "/pharmacyPage/alarmAllList";
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
