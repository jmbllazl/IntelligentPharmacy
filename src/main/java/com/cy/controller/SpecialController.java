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
    public String  anesthesiaAllList(HttpServletRequest request,String pageNum,int state) {
        //分页查询报警数据
        PageInfo drugpage = specialService.selectAllSpecialPageInfo(map,pageNum,5);
        if(drugpage!=null) {
            List<DrugClassification> drugClassificationAllStyle = specialService.drugClassificationAllStyle();
            request.setAttribute("drugClassificationAllStyleList",drugClassificationAllStyle);
            request.setAttribute("specialAllPageList", drugpage);
            if(state==1){
                return "/pharmacyPage/SpecialAllList";
            }
            else if (state==2){
                return "/pharmacyPage/SpecialAllListNum";
            }
            else {
                return "error";
            }
        } else {
            return "error";
        }
    }
    //精神类药品显示
    @RequestMapping("/anesthesiaAllShowList")
    public String alarmStyleShowList(HttpServletRequest request,String pageNum,String drugClassificationId,int state){
        PageInfo drugpage = specialService.selectAllSpecialIdPageInfo(map,pageNum,5,drugClassificationId);
        if(drugpage!=null) {
            List<DrugClassification> drugClassificationAllStyle = specialService.drugClassificationAllStyle();
            request.setAttribute("drugClassificationAllStyleList",drugClassificationAllStyle);
            request.setAttribute("drugClassificationIdNum",drugClassificationId);
            request.setAttribute("specialAllPageList", drugpage);
            if(state==1) {
                return "/pharmacyPage/SpecialAllListId";
            }
           else if(state==2) {
                return "/pharmacyPage/SpecialNum";
            }
            else {
                return "error";
            }
            } else {
            return "error";
        }
    }

    //分页查询所有药房麻醉精神类药品
    @RequestMapping("/anesthesiaPharmacyNum")
    public String  selectAllPharmacyNumPageInfo(HttpServletRequest request,String pageNum) {
        //分页查询报警数据
        PageInfo drugpage = specialService.selectAllPharmacyNumPageInfo(map,pageNum,5);
        if(drugpage!=null) {
            List<DrugClassification> drugClassificationAllStyle = specialService.drugClassificationAllStyle();
            request.setAttribute("drugClassificationAllStyleList",drugClassificationAllStyle);
            request.setAttribute("specialAllPageList", drugpage);
            return "/pharmacyPage/SpecialPharmacyNum";
        } else {
            return "error";
        }
    }

    //精神类药品显示
    @RequestMapping("/anesthesiaAllPharmacyNumId")
    public String anesthesiaAllPharmacyNumId(HttpServletRequest request,String pageNum,String drugClassificationId){
        PageInfo drugpage = specialService.selectAllPharmacyNumIdPageInfo(map,pageNum,5,drugClassificationId);
        if(drugpage!=null) {
            List<DrugClassification> drugClassificationAllStyle = specialService.drugClassificationAllStyle();
            request.setAttribute("drugClassificationAllStyleList",drugClassificationAllStyle);
            request.setAttribute("drugClassificationIdNum",drugClassificationId);
            request.setAttribute("specialAllPageList", drugpage);
            return "/pharmacyPage/SpecialNumPharmacy";
        } else {
            return "error";
        }
    }
    //分页查询所有药房麻醉精神类药品销售数量
    @RequestMapping("/anesthesiaReceiveAllDrug")
    public String  selectReceiveAllDrugPageInfo(HttpServletRequest request,String pageNum) {
        //分页查询报警数据
        PageInfo drugpage = specialService.selectReceiveAllDrugPageInfo(map,pageNum,5);
        if(drugpage!=null) {
            List<DrugClassification> drugClassificationAllStyle = specialService.drugClassificationAllStyle();
            request.setAttribute("drugClassificationAllStyleList",drugClassificationAllStyle);
            request.setAttribute("specialAllPageList", drugpage);
            return "/pharmacyPage/aeceiveReceiveAllDrugList";
        } else {
            return "error";
        }
    }

    //精神类药品显示
    @RequestMapping("/aeceiveReceiveAllDrugListId")
    public String aeceiveReceiveAllDrugListId(HttpServletRequest request,String pageNum,String drugClassificationId){
        PageInfo drugpage = specialService.selectReceiveAllDrugIdPageInfo(map,pageNum,5,drugClassificationId);
        if(drugpage!=null) {
            List<DrugClassification> drugClassificationAllStyle = specialService.drugClassificationAllStyle();
            request.setAttribute("drugClassificationAllStyleList",drugClassificationAllStyle);
            request.setAttribute("drugClassificationIdNum",drugClassificationId);
            request.setAttribute("specialAllPageList", drugpage);
            return "/pharmacyPage/aeceiveReceiveAllDrugListId";
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
