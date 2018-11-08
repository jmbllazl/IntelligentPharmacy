package com.cy.controller;

import com.cy.bean.*;
import com.cy.biz.AlarmService;
import com.cy.biz.SpecialService;
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
@RequestMapping("/anesthesia")
public class SpecialController {
    private Map<String,Object> map = new HashMap<>();
    @Autowired
    private DrugClassification drugClassification;
    @Autowired
    private DrugStore drugStore;
    @Autowired
    private SpecialService specialService;

    //分页查询所有麻醉精神类药品
    @RequestMapping("/anesthesiaAllList")
    public String  anesthesiaAllList(HttpServletRequest request,String pageNum) {
        //分页查询报警数据
        PageInfo drugpage = specialService.selectAllSpecialPageInfo(map,pageNum,5);
        if(drugpage!=null) {
            List<DrugClassification> drugClassificationAllStyle = specialService.drugClassificationAllStyle();
            request.setAttribute("drugClassificationAllStyleList",drugClassificationAllStyle);

            request.setAttribute("specialAllPageList", drugpage);
            return "/pharmacyPage/SpecialAllList";
        } else {
            return "error";
        }
    }

    @RequestMapping("/anesthesiaAllShowList")
    public String alarmStyleShowList(HttpServletRequest request,String pageNum,String drugClassificationId){
        PageInfo drugpage = specialService.selectAllSpecialIdPageInfo(map,pageNum,5,drugClassificationId);
        if(drugpage!=null) {
            List<DrugClassification> drugClassificationAllStyle = specialService.drugClassificationAllStyle();
            request.setAttribute("drugClassificationAllStyleList",drugClassificationAllStyle);
            request.setAttribute("drugClassificationIdNum",drugClassificationId);
            request.setAttribute("specialAllPageList", drugpage);
            return "/pharmacyPage/SpecialAllListId";
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
