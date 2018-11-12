package com.cy.controller;

import com.cy.bean.DrugClassification;
import com.cy.bean.DrugStore;
import com.cy.bean.PhamacyReceive;
import com.cy.biz.PhamacyService;
import com.cy.biz.ReportService;
import com.cy.biz.SpecialService;
import com.cy.util.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/report")
public class ReportController {
    private Map<String,Object> map = new HashMap<>();
    @Autowired
    private DrugClassification drugClassification;
    @Autowired
    private DrugStore drugStore;
    @Autowired
    private ReportService reportService;
    @Autowired
    private PhamacyService phamacyService;

    //分页查询所有药库药品
    @RequestMapping("/reportAllList")
    public String  anesthesiaAllList(HttpServletRequest request,String pageNum,int state) {
        // 等于1的时候是药房
        if(state==1) {
            PageInfo drugpage = reportService.selectAllNumPharmacyNumPageInfo(map, pageNum, 5);
            if (drugpage != null) {
                List<DrugClassification> drugClassificationAllStyle = reportService.drugClassificationAllStyle();
                request.setAttribute("drugClassificationAllStyleList", drugClassificationAllStyle);
                request.setAttribute("specialAllPageList", drugpage);
                return "/pharmacyPage/reportAllList";
                }
            else {
                return "error";
              }
            }
        // 等于2的时候是药库
        else if (state == 2) {
            PageInfo drugpage = reportService.selectAllNumDrugPageInfo(map, pageNum, 5);
            if (drugpage != null) {
                List<DrugClassification> drugClassificationAllStyle = reportService.drugClassificationAllStyle();
                request.setAttribute("drugClassificationAllStyleList", drugClassificationAllStyle);
                request.setAttribute("specialAllPageList", drugpage);
                return "/pharmacyPage/reportAllListStore";
            } else {
                return "error";
            }
        }
        return "error";
    }
    //精神类药品显示
    @RequestMapping("/reportAllListShowList")
    public String alarmStyleShowList(HttpServletRequest request,String pageNum,String drugClassificationId,int state) {
        if (state == 1) {
            PageInfo drugpage = reportService.selectAllNumDrugIdPharmacyPageInfo(map, pageNum, 5, drugClassificationId);
            if (drugpage != null) {
                List<DrugClassification> drugClassificationAllStyle = reportService.drugClassificationAllStyle();
                request.setAttribute("drugClassificationAllStyleList", drugClassificationAllStyle);
                request.setAttribute("drugClassificationIdNum", drugClassificationId);
                request.setAttribute("specialAllPageList", drugpage);
                return "/pharmacyPage/reportAllListShowId";
            }
                return "error";
        }
        else if (state == 2) {
            PageInfo drugpage = reportService.selectAllNumDrugIdPageInfo(map, pageNum, 5, drugClassificationId);
            if (drugpage != null) {
                List<DrugClassification> drugClassificationAllStyle = reportService.drugClassificationAllStyle();
                request.setAttribute("drugClassificationAllStyleList", drugClassificationAllStyle);
                request.setAttribute("drugClassificationIdNum", drugClassificationId);
                request.setAttribute("specialAllPageList", drugpage);
                return "/pharmacyPage/reportAllListShowStroeId";
            }
            return "error";
        }
        return "error";

    }
    //药品报损
    @RequestMapping("/selectPhamacyReceivesAllList.action")
    public String selectPhamacyReceive(HttpServletRequest request, String num , String state,String drugName,String receiveDate){
       if(!StringUtils.isEmpty(drugName)){
            map.put("drugName",drugName);
        }
        PageInfo<PhamacyReceive> phamacyReceive =reportService.selectPhamacyReceivePageInfo(map, num, 10);

        if (phamacyReceive!=null) {
            map.clear();
            HttpSession session = request.getSession();
            request.setAttribute("phamacyReceive",phamacyReceive);
            return "/pharmacyPage/phamacyReceivesAllList";
        } else {
            return "error";
        }
    }
    //药品调价
    @RequestMapping("/priceReceiveDrugList.action")
    public String selectPriceReceiveDrugList(HttpServletRequest request, String num , String state,String drugName,String receiveDate){
        if(!StringUtils.isEmpty(drugName)){
            map.put("drugName",drugName);
        }
        PageInfo<PhamacyReceive> phamacyReceive =reportService.selectPriceReceiveDrugListPageInfo(map, num, 10);

        if (phamacyReceive!=null) {
            map.clear();
            HttpSession session = request.getSession();
            request.setAttribute("phamacyReceive",phamacyReceive);
            return "/pharmacyPage/priceReceiveDrugList";
        } else {
            return "error";
        }
    }
    //报损id查询报损信息
    @RequestMapping("/selectPhamacyDrugReceiveDetilsAllId.action")
    public  String selectPhamacyDrugReceiveDetils(HttpServletRequest request,String drugName,String receiverId ){
        PhamacyReceive phamacyReceive = new PhamacyReceive();
        if(!StringUtils.isEmpty(receiverId)){
            int a = Integer.parseInt(receiverId);
            phamacyReceive = phamacyService.selectPhamacyImage(a);
            request.setAttribute("phamacyReceive",phamacyReceive);
            request.setAttribute("drugName",drugName);
        }
        return "/pharmacyPage/phamacyAllDetils";
    }
    //盘点药房
    @RequestMapping("/reportAllDrugs.action")
    public String  reportAllDrugs(HttpServletRequest request, String num , String drugName,String drugNumber,String formulation){
        if(!StringUtils.isEmpty(drugName)){
            map.put("drugName",drugName);
        }if(!StringUtils.isEmpty(drugNumber)){
            map.put("drugNumber",Integer.parseInt(drugNumber));
        }if(!StringUtils.isEmpty(formulation)){
            map.put("formulation",formulation);
        }
        PageInfo  drugpage = phamacyService.selectPhamacyAllDrugsPageInfo(map, num,3);
        if (drugpage!=null) {
            map.clear();
            request.setAttribute("drugpage",drugpage);
            return "/pharmacyPage/reportAllDrugs";
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
