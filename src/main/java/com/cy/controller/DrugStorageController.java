package com.cy.controller;

import com.cy.bean.*;
import com.cy.biz.DrugStorageService;
import com.cy.biz.PhamacyService;
import com.cy.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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

    Gson gson = new Gson();
    int state ;//药品详情

    //强制转换
    public static int toInt(String strNum ){
        Integer integer = new Integer(strNum);
        return integer.parseInt(strNum);
    }

    //药品信息设置页面
    @RequestMapping("/drugSetUp.action")
    public  String drugSetUp(HttpServletRequest request){
        List<DrugClassification> drugClassification = phamacyService.selectDrugClassification();
        request.setAttribute("drugClassification",drugClassification);
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
                    purchase.setDrugName(drugStorageServiceImp.drugName(toInt(selected[i])));
                    purchase.setDrugQuantity(toInt(drugs[i]));
                    Date ss = new Date();
                    SimpleDateFormat nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    String time = nowDate.format(ss.getTime());
                    purchase.setReceivedDate(time);
                    purchase.setState("审核中");
                    purchase.setAdminName(AdminController.adminName);
                    drugChaseList.add(purchase);
                }
            }
        }
        int result= drugStorageServiceImp.addPurchase(drugChaseList);
        return "forward:/phamacy/selectPurasePage.action";
    }

    //药品采购单显示
    @RequestMapping("/selectPurasePage.action")
    public String selectPurasePage(HttpServletRequest request, String num){
        PageInfo<Purchase> phamacyPurchase = drugStorageServiceImp.selectPhamacyReceivePageInfo(num, 10);
        request.setAttribute("phamacyPurchase",phamacyPurchase);
        return "/pharmacyPage/phamacyPurase";
    }

    //删除采购单
    @RequestMapping("/purchaseDetele.action")
    public String purchaseDetele(int drugId){
        drugStorageServiceImp.purchaseDetele(drugId);
        return "forward:/phamacy/selectPurasePage.action";
    }

    //管理员审核
    @RequestMapping("phamacyPuraseExamine.action")
    public String phamacyPuraseExamine(HttpServletRequest request, String num){
        PageInfo<Purchase> phamacyPurchase = drugStorageServiceImp.selectPhamacyReceivePageInfo(num, 10);
        request.setAttribute("phamacyPurchase",phamacyPurchase);
        return "/pharmacyPage/phamacyPuraseExamine";
    }

    //采购单通过审核
    @RequestMapping("/reviewPass.action")
    public String reviewPass(int purchaseId,int drugQuantity,String drugName){
        drugStorageServiceImp.reviewPass(purchaseId);
        //通过审核将药品的数量增加
        Purchase purchase=new Purchase(drugQuantity,drugName);
        drugStorageServiceImp.addDrug(purchase);
        return "forward:/phamacy/phamacyPuraseExamine.action";
    }

    //采购单不通过审核
    @RequestMapping("/noReviewPass.action")
    public String noReviewPass(int purchaseId){
        drugStorageServiceImp.noReviewPass(purchaseId);
        return "forward:/phamacy/phamacyPuraseExamine.action";
    }

    //退还厂家页面
    @RequestMapping("/drugStoreOut.action")
    public String drugStoreOut(HttpServletRequest request){
        List<DrugClassification> drugClassification = phamacyService.selectDrugClassification();
        request.setAttribute("drugClassification",drugClassification);
        return "/pharmacyPage/drugStoreOut";
    }

    //药品退还厂家提交
    @RequestMapping("/submitDrugStoreOut.action")
    public String submitDrugStoreOut(HttpServletRequest request ,String[] drugQuantity,String[] selected ,String[] outReason){
        String cmd = null;
        for(int i = 0; i<outReason.length;i++){
           if(!StringUtils.isEmpty(outReason[i])){
              cmd =outReason[i];
           }
       }
       if(cmd.contains("申领")){
           addRecevieDrug(request,drugQuantity,selected,cmd);
           submitDrugStore(request , drugQuantity,selected , outReason);
           return "forward:/phamacy/selectPhamacyReceive.action";
       }else{
           submitDrugStore(request , drugQuantity,selected , outReason); 
           return "forward:/phamacy/selectDrugStoreOut.action";
       }
    }
    //药品退还厂家提交
    public void submitDrugStore(HttpServletRequest request ,String[] drugQuantity,String[] selected ,String[] outReason){
        List<DrugStoreOut> drugStoreOutList = new ArrayList<DrugStoreOut>();
        String [] drugs = new String[10];
        String [] reason = new String[10];
        if(drugQuantity!=null||selected!=null){
            int a=0;
            for(int j=0;j<drugQuantity.length;j++) {
                if (drugQuantity[j] != "") {
                    drugs[a] = drugQuantity[j];
                    reason[a] = outReason[j];
                    a++;
                }
            }
            for(int i=0;i<selected.length;i++){
                if(selected[i]!=""){
                    DrugStoreOut drugStoreOut= new DrugStoreOut();
                    drugStoreOut.setDrugName(drugStorageServiceImp.drugName(toInt(selected[i])));
                    drugStoreOut.setDrugQuantity(toInt(drugs[i]));
                    Date ss = new Date();
                    SimpleDateFormat nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    String time = nowDate.format(ss.getTime());
                    drugStoreOut.setReceiveDate(time);
                    drugStoreOut.setState("审核中");
                    drugStoreOut.setDrugStoreOutName("退货");
                    drugStoreOut.setOutReason(reason[i]);
                    drugStoreOut.setAdminName(AdminController.adminName);
                    drugStoreOutList.add(drugStoreOut);
                }
            }
        }
        int result= drugStorageServiceImp.drugStoreOut(drugStoreOutList);
    }
    //药品申领
    public void addRecevieDrug(HttpServletRequest request ,String[] drugQuantity,String[] selected,String drugDetails){
        List<PhamacyReceive> phamacyReceiveList = new ArrayList<PhamacyReceive>();
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
                    PhamacyReceive phamacyReceive= new PhamacyReceive();
                    phamacyReceive.setPharmacyId(Integer.parseInt(selected[i]));
                    phamacyReceive.setPhamacyDrugQuantity(Integer.parseInt(drugs[i]));
                    Date ss = new Date();
                    SimpleDateFormat nowDate = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                    String time = nowDate.format(ss.getTime());
                    phamacyReceive.setReceiveDate(time);
                    phamacyReceive.setState("审核中");
                    phamacyReceive.setReceiverDrug(drugDetails);
                    HttpSession session = request.getSession();
                    Admin admin = (Admin)session.getAttribute("admin");
                    phamacyReceive.setAdminId(admin.getAdminId());
                    phamacyReceive.setUserId(1);
                    phamacyReceiveList.add(phamacyReceive);
                }
            }
        }
        
        int result= phamacyService.addPhamacyReceiveDrugs(phamacyReceiveList);
    }
    //药品退还厂家单显示
    @RequestMapping("/selectDrugStoreOut.action")
    public String selectDrugStoreOut(HttpServletRequest request, String num){
        PageInfo<DrugStoreOut> drugStoreOut = drugStorageServiceImp.selectDrugStoreOut(num, 10);
        request.setAttribute("drugStoreOut",drugStoreOut);
        return "/pharmacyPage/drugStoreOutResult";
    }

    //删除退还厂家单
    @RequestMapping("/DrugStoreOutDetele.action")
    public String DrugStoreOutDetele(int drugStoreOutId){
        drugStorageServiceImp.drugStoreOutDetele(drugStoreOutId);
        return "forward:/phamacy/selectDrugStoreOut.action";
    }

    //退库审核
    @RequestMapping("drugStoreOutResultExamine.action")
    public String drugStoreOutResultExamine(HttpServletRequest request, String num){
        PageInfo<DrugStoreOut> drugStoreOut = drugStorageServiceImp.selectDrugStoreOut(num, 10);
        request.setAttribute("drugStoreOut",drugStoreOut);
        return "/pharmacyPage/drugStoreOutResultExamine";
    }

    //退库审核通过
    @RequestMapping("/drugStoreOutReviewPass.action")
    public String drugStoreOutReviewPass(int drugStoreOutId,int drugQuantity,String drugName,String outReason){
        drugStorageServiceImp.drugStoreOutReviewPass(drugStoreOutId);
        //通过审核将药品的数量减少
        DrugStoreOut drugStoreOut=new DrugStoreOut(drugQuantity,drugName,outReason);
        drugStorageServiceImp.reduceDrug(drugStoreOut);
        return "forward:/phamacy/drugStoreOutResultExamine.action";
    }

    //退库审核不通过
    @RequestMapping("/drugStoreOutNoReviewPass.action")
    public String drugStoreOutNoReviewPass(int drugStoreOutId){
        drugStorageServiceImp.drugStoreOutNoReviewPass(drugStoreOutId);
        return "forward:/phamacy/drugStoreOutResultExamine.action";
    }

    //医保药品核对界面
    @RequestMapping("/medicalInsurance.action")
    public String medicalInsurance(HttpServletRequest request){
        List<DrugClassification> drugClassification = phamacyService.selectDrugClassification();
        request.setAttribute("drugClassification",drugClassification);
        return "/pharmacyPage/medicalInsuranceDrug";
    }

    //医保设置提交
    @RequestMapping("submitMedicalInsurance.action")
    public String submitMedicalInsurance(HttpServletRequest request ,String[] medicalinsurance,String[] selected ,String[] reimbursementRatio){
        List<DrugStoreOut> drugStoreOutList = new ArrayList<DrugStoreOut>();
        String [] medicalinsuranceNum = new String[10];
        String [] reimbursementRatioNum = new String[10];
        if(medicalinsurance!=null||selected!=null||reimbursementRatio!=null){
            int a=0;
            for(int j=0;j<medicalinsurance.length;j++) {
                if (medicalinsurance[j] != "") {
                    medicalinsuranceNum[a] = medicalinsurance[j];
                    reimbursementRatioNum[a] = reimbursementRatio[j];
                    a++;
                }
            }
            for(int i=0;i<selected.length;i++){
                if(selected[i]!=""){
                    System.out.println("医保："+ medicalinsuranceNum[i]);
                    System.out.println("报销比例："+ reimbursementRatioNum[i]);
                }
            }
        }
        int result= drugStorageServiceImp.drugStoreOut(drugStoreOutList);
        return "forward:/phamacy/selectDrugStoreOut.action";
    }

    @RequestMapping("/batchList")//按种类批次统计,默认显示当天入库品种1为全部药品,2为种类,3为批号,4为详情
    public void batchList(HttpServletRequest request, HttpServletResponse response, DrugStore drugStore, String conditionQuery) throws ServletException, IOException {
        state = drugStore.getState();
        PageInfo pageDrug;
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> map = new HashMap<String, Object>();
        List<DrugStore> drugList;
        List<DrugStoreOutTable>drugStoreOutTableList;
        int[] outDrug;//出库数量
        int[]inDrug;//入库数量
        int[]outMoney;//出库金额
        int[]inMoney;//入库金额
        String []batch;//批次
        String []drugMonth;//月份
        if (state>0) {
            if(state==5){//画出本年度的柱状图详情
                System.out.println(drugStore.getDrugName());
                drugList= drugStorageServiceImp.findAllDrugStoreYearDetails(drugStore.getDrugName());
                inDrug=new int[drugList.size()];
                outDrug=new int[drugList.size()];
                outMoney=new int[drugList.size()];
                inMoney=new int[drugList.size()];
                batch=new String[drugList.size()];
                drugMonth=new String[drugList.size()];
                for(int i=0;i<drugList.size();i++){
                    outDrug[i]=drugList.get(i).getOutCount();
                    inDrug[i]=drugList.get(i).getInCount();
                    outMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getOutCount();
                    inMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getInCount();
                    batch[i]=drugList.get(i).getLotNumber();
                    drugMonth[i]=""+drugList.get(i).getStorageTime()+"月";
                }
                map.put("outDrug",outDrug);
                map.put("inDrug",inDrug);
                //map.put("outMoney",outMoney);
                //map.put("inMoney",inMoney);
                map.put("batch",batch);
                map.put("dataDrugMonth",drugMonth);
                String jsonStr = gson.toJson(map);
                System.out.println(jsonStr);
                response.getWriter().write(jsonStr);

            }else if(state==4){
                String drugName=request.getParameter("drugName");
                request.setAttribute("drugName",drugName);
                request.getRequestDispatcher("/WEB-INF/pharmacyPage/drugDetails.jsp").forward(request, response);
            }else if(state==6){
                drugList= drugStorageServiceImp.findAllDrugStoreWeekOutDetails(drugStore.getDrugName());
                inDrug=new int[drugList.size()];
                outDrug=new int[drugList.size()];
                outMoney=new int[drugList.size()];
                inMoney=new int[drugList.size()];
                batch=new String[drugList.size()];
                drugMonth=new String[drugList.size()];
                for(int i=0;i<drugList.size();i++){
                    outDrug[i]=drugList.get(i).getOutCount();
                    inDrug[i]=drugList.get(i).getInCount();
                    outMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getOutCount();
                    inMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getInCount();
                    batch[i]=drugList.get(i).getLotNumber();
                    drugMonth[i]=""+drugList.get(i).getStorageTime()+"";
                }
                map.put("outDrug",outDrug);
                map.put("inDrug",inDrug);
                //map.put("outMoney",outMoney);
                //map.put("inMoney",inMoney);
                map.put("batch",batch);
                map.put("dataDrugMonth",drugMonth);
                String jsonStr = gson.toJson(map);
                System.out.println(jsonStr);
                response.getWriter().write(jsonStr);
            }else if(state==7){
                drugList= drugStorageServiceImp.findAllDrugStoreMouthOutDetails(drugStore.getDrugName());
                inDrug=new int[drugList.size()];
                outDrug=new int[drugList.size()];
                outMoney=new int[drugList.size()];
                inMoney=new int[drugList.size()];
                batch=new String[drugList.size()];
                drugMonth=new String[drugList.size()];
                for(int i=0;i<drugList.size();i++){
                    outDrug[i]=drugList.get(i).getOutCount();
                    inDrug[i]=drugList.get(i).getInCount();
                    outMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getOutCount();
                    inMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getInCount();
                    batch[i]=drugList.get(i).getLotNumber();
                    drugMonth[i]=""+drugList.get(i).getStorageTime()+"周";
                }
                map.put("outDrug",outDrug);
                map.put("inDrug",inDrug);
                //map.put("outMoney",outMoney);
                //map.put("inMoney",inMoney);
                map.put("batch",batch);
                map.put("dataDrugMonth",drugMonth);
                String jsonStr = gson.toJson(map);
                System.out.println(jsonStr);
                response.getWriter().write(jsonStr);
            }else if(state==8){
                drugList= drugStorageServiceImp.findAllDrugStoreMouthInDetails(drugStore.getDrugName());
                inDrug=new int[drugList.size()];
                outDrug=new int[drugList.size()];
                outMoney=new int[drugList.size()];
                inMoney=new int[drugList.size()];
                batch=new String[drugList.size()];
                drugMonth=new String[drugList.size()];
                for(int i=0;i<drugList.size();i++){
                    //outDrug[i]=drugList.get(i).getOutCount();
                    inDrug[i]=drugList.get(i).getInCount();
                    outMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getOutCount();
                    inMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getInCount();
                    batch[i]=drugList.get(i).getLotNumber();
                    drugMonth[i]=""+drugList.get(i).getStorageTime()+"月";
                }
                map.put("outDrug",outDrug);
                map.put("inDrug",inDrug);
                //map.put("outMoney",outMoney);
                //map.put("inMoney",inMoney);
                map.put("batch",batch);
                map.put("dataDrugMonth",drugMonth);
                String jsonStr = gson.toJson(map);
                System.out.println(jsonStr);
                response.getWriter().write(jsonStr);

            }else if(state==9){
                drugList= drugStorageServiceImp.findAllDrugStoreMouthInDetails(drugStore.getDrugName());
                inDrug=new int[drugList.size()];
                outDrug=new int[drugList.size()];
                outMoney=new int[drugList.size()];
                inMoney=new int[drugList.size()];
                batch=new String[drugList.size()];
                drugMonth=new String[drugList.size()];
                for(int i=0;i<drugList.size();i++){
                    // outDrug[i]=drugList.get(i).getOutCount();
                    inDrug[i]=drugList.get(i).getInCount();
                    outMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getOutCount();
                    inMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getInCount();
                    batch[i]=drugList.get(i).getLotNumber();
                    drugMonth[i]=""+drugList.get(i).getStorageTime()+"周";
                }
                map.put("outDrug",outDrug);
                map.put("inDrug",inDrug);
                //map.put("outMoney",outMoney);
                //map.put("inMoney",inMoney);
                map.put("batch",batch);
                map.put("dataDrugMonth",drugMonth);
                String jsonStr = gson.toJson(map);
                System.out.println(jsonStr);
                response.getWriter().write(jsonStr);

            }else if(state==10){
                System.out.println("ooo"+drugStore.getDrugName());
                drugList= drugStorageServiceImp.findAllDrugStoreMouthInDetails(drugStore.getDrugName());
                inDrug=new int[drugList.size()];
                outDrug=new int[drugList.size()];
                outMoney=new int[drugList.size()];
                inMoney=new int[drugList.size()];
                batch=new String[drugList.size()];
                drugMonth=new String[drugList.size()];
                for(int i=0;i<drugList.size();i++){
                    // outDrug[i]=drugList.get(i).getOutCount();
                    inDrug[i]=drugList.get(i).getInCount();
                    outMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getOutCount();
                    inMoney[i]=drugList.get(i).getDrugPrice()*drugList.get(i).getInCount();
                    batch[i]=drugList.get(i).getLotNumber();
                    drugMonth[i]=""+drugList.get(i).getStorageTime()+"";
                }
                map.put("outDrug",outDrug);
                map.put("inDrug",inDrug);
                //map.put("outMoney",outMoney);
                //map.put("inMoney",inMoney);
                map.put("batch",batch);
                map.put("dataDrugMonth",drugMonth);
                String jsonStr = gson.toJson(map);
                System.out.println(jsonStr);
                response.getWriter().write(jsonStr);

            }else if(state==11){
                String drugName=request.getParameter("drugName");
                request.setAttribute("drugName",drugName);
                request.getRequestDispatcher("/WEB-INF/pharmacyPage/inDrugDetails.jsp").forward(request, response);
            }

            else {
                int pagesize = Integer.parseInt(request.getParameter("limit"));
                int pageNum = Integer.parseInt(request.getParameter("page"));
                map.put("code", 0);
                map.put("msg", "");
                if (state == 1) {
                    pageDrug = drugStorageServiceImp.findAllDrugStore(pageNum, pagesize);
                    drugList = pageDrug.getList();
                    map.put("count", pageDrug.getTotal());
                    map.put("data", drugList);
                    String jsonStr = gson.toJson(map);
                    response.getWriter().write(jsonStr);
                } else if (state == 2) {//入库明细查询
                    pageDrug = drugStorageServiceImp.findAllBatchDrugStore(pageNum, pagesize);
                    drugList = pageDrug.getList();
                    map.put("count", pageDrug.getTotal());
                    map.put("data", drugList);
                    String jsonStr = gson.toJson(map);
                    response.getWriter().write(jsonStr);
                } else if (state == 3) {//出库查询
                    pageDrug = drugStorageServiceImp.findAllSortDrugStore(pageNum, pagesize);
                    drugStoreOutTableList = pageDrug.getList();
                    map.put("count", pageDrug.getTotal());
                    map.put("data", drugStoreOutTableList);
                    String jsonStr = gson.toJson(map);
                    response.getWriter().write(jsonStr);

                }else if(state==12){
                    pageDrug = drugStorageServiceImp.findAllConditonDrugStore(pageNum, pagesize,conditionQuery);
                    drugList = pageDrug.getList();
                    map.put("count", pageDrug.getTotal());
                    map.put("data", drugList);
                    String jsonStr = gson.toJson(map);
                    response.getWriter().write(jsonStr);
                }

            }
        } else {
            List<DrugClassification> drugClassification = drugStorageServiceImp.findAllKindDrugStore();
            request.setAttribute("drugStoreList", drugClassification);
            request.getRequestDispatcher("/WEB-INF/pharmacyPage/detailedListDrugs.jsp").forward(request, response);
        }

    }

    @RequestMapping("/purchase")
    @ResponseBody
    public Map purchase(HttpServletRequest request,HttpServletResponse response,Integer state,String conditionQuery) throws ServletException, IOException {
        PageInfo pageDrug;
        Map<String, Object> map = new HashMap<String, Object>();
        List<DrugStore> drugList;
        if(state==null){
            request.getRequestDispatcher("/WEB-INF/pharmacyPage/purchaseDetails.jsp").forward(request, response);
        }else {
            int pagesize = Integer.parseInt(request.getParameter("limit"));
            int pageNum = Integer.parseInt(request.getParameter("page"));
            map.put("code", 0);
            map.put("msg", "");
            if (state == 1) {
                pageDrug = drugStorageServiceImp.findPurchase(pageNum, pagesize);
                drugList = pageDrug.getList();
                map.put("count", pageDrug.getTotal());
                map.put("data", drugList);
                return map;
            } else if (state == 2) {
                pageDrug = drugStorageServiceImp.findConditionPurchase(pageNum, pagesize, conditionQuery);
                drugList = pageDrug.getList();
                map.put("count", pageDrug.getTotal());
                map.put("data", drugList);
                return map;
            }
        }
        return null;

    }

}
