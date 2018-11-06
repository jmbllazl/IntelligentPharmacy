package com.cy.controller;

import com.cy.bean.*;
import com.cy.biz.DrugStorageService;
import com.cy.biz.PhamacyService;
import com.cy.util.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/phamacy")
public class DrugStorageController  {

    private Map<String,Object> map = new HashMap<>();
    @Autowired
    private PhamacyService phamacyService;
    @Resource
    private DrugStorageService drugStorageServiceImp;

    //强制转换
    public static int toInt(String strNum ){
        Integer integer = new Integer(strNum);
        return integer.parseInt(strNum);
    }

    //药品信息设置页面
    @RequestMapping("/drugSetUp.action")
    public  String drugSetUp(){
        return "/pharmacyPage/drugSetUp";
    }

    //药品信息提交
    @RequestMapping("/submitDrugSetUp.action")
    public String submitDrugSetUp(HttpServletRequest request){
        String drugName = request.getParameter("drugName");
        int drugNumber = toInt(request.getParameter("drugNumber"));
        int drugClass = toInt(request.getParameter("drugClass"));
        String drugDetailed = request.getParameter("drugDetailed");
        String formUlarion = request.getParameter("formUlarion");
        String norm = request.getParameter("norm");
        String unit = request.getParameter("unit");
        int drugPrice =toInt(request.getParameter("drugPrice"));
        String approvalNumber = request.getParameter("approvalNumber");
        String produtionDate = request.getParameter("produtionDate");
        String lotNumber = request.getParameter("lotNumber");
        String validaiTypeRiod = request.getParameter("validaiTypeRiod");
        String manufacTurer = request.getParameter("manufacTurer");
        String storageTime = request.getParameter("storageTime");
        String drugPhoto = request.getParameter("drugPhoto");
        String dayConsumption = request.getParameter("dayConsumption");
        DrugStore drugStore=new DrugStore(drugName,drugNumber,drugClass,drugDetailed,formUlarion,norm,unit,
                drugPrice,approvalNumber,produtionDate,lotNumber,validaiTypeRiod,manufacTurer,storageTime,
                drugPhoto,dayConsumption);
        drugStorageServiceImp.DrugPurchase(drugStore);
        return "/pharmacyPage/drugSetUpSuccessful";
    }

    //药品采购页面
    @RequestMapping("/drugPurchase.action")
    public String drugPurchase(HttpServletRequest request){
        List<DrugClassification> drugClassification = phamacyService.selectDrugClassification();
        request.setAttribute("drugClassification",drugClassification);
        return "/pharmacyPage/drugPurchase";
    }

    //选择分类后药品显示
    @RequestMapping(value = "selectDrugStore.action",method=RequestMethod.POST, produces="application/json;charset=utf-8")
    public  @ResponseBody PageInfo<DrugStore> selectDrugStore(String drugClassifications, String num){
        PageInfo<DrugStore> drugStoreList=new PageInfo<DrugStore>();
        if(!StringUtils.isEmpty(drugClassifications)){
            drugStoreList=drugStorageServiceImp.selectDrugStore(toInt(drugClassifications),num,3);
        }
        return drugStoreList;
    }

    //药品采购提交
    @RequestMapping("/submitdrugPurchase.action")
    public String submitdrugPurchase(HttpServletRequest request ,String[] drugQuantity,String[] selected){

        List<Purchase> drugChaseList = new ArrayList<Purchase>();
        String [] drugs = new String[10];
        int a=0;
        if(drugQuantity!=null||selected!=null){
            for(int j=0;j<drugQuantity.length;j++) {
                if (drugQuantity[j] != "") {
                    drugs[a] = drugQuantity[j];
                    a++;
                }
            }
            for(int i=0;i<selected.length;i++){
                if(selected[i]!=""){
                    Purchase purchase= new Purchase();
                    purchase.setDrugId(toInt(selected[i]));
                    purchase.setDrugQuantity(toInt(drugs[i]));
                    Date ss = new Date();
                    SimpleDateFormat nowDate = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                    String time = nowDate.format(ss.getTime());
                    purchase.setReceivedDate(time);
                    purchase.setState("审核中");
                    purchase.setAdminName(AdminController.adminName);
                    drugChaseList.add(purchase);
                }
            }
        }
        int result= drugStorageServiceImp.addPurchase(drugChaseList);
        return "forward:/phamacy/selectPurase.action";
    }
    //药品采购单审核查询
    @RequestMapping("/selectPurase.action")
    public String selectPurase(HttpServletRequest request, String num , String state,String drugName,String receiveDate){

        if(!StringUtils.isEmpty(state)){
            map.put("state",state);
        }if(!StringUtils.isEmpty(drugName)){
            map.put("drugName",drugName);
        }if(!StringUtils.isEmpty(receiveDate)){
            map.put("receiveDate",receiveDate);
        }
        PageInfo<PhamacyReceive> phamacyReceive = phamacyService.selectPhamacyReceivePageInfo(map, num, 10);

        if (phamacyReceive!=null) {
            map.clear();
            HttpSession session = request.getSession();
            request.setAttribute("phamacyReceive",phamacyReceive);
            return "/pharmacyPage/phamacyPurase";
        } else {
            return "error";
        }
    }

    //药品采购单显示
    @RequestMapping("/selectPurasePage.action")
    public String selectPurasePage(HttpServletRequest request, String num , String state,String drugName,String receivedDate){

        if(!StringUtils.isEmpty(state)){
            map.put("state",state);
        }if(!StringUtils.isEmpty(drugName)){
            map.put("drugName",drugName);
        }if(!StringUtils.isEmpty(receivedDate)){
            map.put("receiveDate",receivedDate);
        }
        PageInfo<Purchase> phamacyPurchase = drugStorageServiceImp.selectPhamacyReceivePageInfo(map, num, 10);

        if (phamacyPurchase!=null) {
            map.clear();
            HttpSession session = request.getSession();
            request.setAttribute("phamacyPurchase",phamacyPurchase);
            return "/pharmacyPage/phamacyPurase";
        } else {
            return "error";
        }

    }

}
