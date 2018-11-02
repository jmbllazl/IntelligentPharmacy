package com.cy.controller;

import com.cy.biz.PhamacyService;
import com.cy.util.AlamDemo;
import com.cy.util.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/alarm")
public class AlarmController {
    private Map<String,Object> map = new HashMap<>();
    @Autowired
    private PhamacyService phamacyService;

    @Autowired
    private AlamDemo alamDemo;
    @RequestMapping("/alarmAllDrugs.action")
    public String  alarmNumAllDrugsDrugs(HttpServletRequest request,String num ){
        PageInfo drugpage = phamacyService.selectAlarmNumAllDrugsPageInfoPageInfo(map, num,4);
        if (drugpage!=null) {
            System.out.println("低于限制数量警报");
            // map.put("drugpage",drugpage);
           HttpSession session = request.getSession();
           session.setAttribute("drugpage",drugpage);
           return "/pharmacyPage/alarmAllDrugs";
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
