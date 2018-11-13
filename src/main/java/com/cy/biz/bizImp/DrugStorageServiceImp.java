package com.cy.biz.bizImp;

import com.cy.bean.*;
import com.cy.biz.DrugStorageService;
import com.cy.mapper.DrugStorageManage;
import com.cy.mapper.PhamacyDrugManager;
import com.cy.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DrugStorageServiceImp implements DrugStorageService {

    @Resource
    DrugStorageManage drugStorageManage;
    @Autowired
    private PhamacyDrugManager phamacyDrugManager;
    @Override
    public void DrugPurchase(DrugStore phamacyDrug) {
        drugStorageManage.DrugPurchase(phamacyDrug);
    }

    @Override
    public PageInfo<DrugStore> selectDrugStore(int drugClassificationId,String page, int size) {
        int page1=0;
        if(StringUtils.isEmpty(page)){
            page1 = Integer.parseInt(page="1");
        }else{
            page1 = Integer.parseInt(page);
        }
        //selectByUsers调用的是前面没分页的方法
        PageHelper.startPage(page1,size);
        ArrayList<DrugStore> phamacyReceiveListPageInfo = drugStorageManage.selectDrugStore(drugClassificationId);
        PageInfo<DrugStore> phamacyDrugs = new PageInfo<DrugStore>(phamacyReceiveListPageInfo);
        return phamacyDrugs;
    }

    @Override
    public int addPurchase(List<Purchase> purchase) {
        return drugStorageManage.addPurchase(purchase);
    }

    @Override
    public PageInfo<Purchase> selectPhamacyReceivePageInfo(String page, int size) {
        int page1=0;
        if(StringUtils.isEmpty(page)){
            page1 = Integer.parseInt(page="1");
        }else{
            page1 = Integer.parseInt(page);
        }
        //selectByUsers调用的是前面没分页的方法
        PageHelper.startPage(page1,size);
        List<Purchase> phamacyReceiveListPageInfo = (List<Purchase>) drugStorageManage.selectPhamacyReceivePageInfo();
        PageInfo<Purchase> phamacyReceiveList = new PageInfo<Purchase>(phamacyReceiveListPageInfo);
        return phamacyReceiveList;
    }

    @Override
    public String drugName(int drugId) {
        return drugStorageManage.drugName(drugId);
    }

    @Override
    public void purchaseDetele(int drugId) {
        drugStorageManage.purchaseDetele(drugId);
    }

    @Override
    public void reviewPass(int purchaseId) {
        drugStorageManage.reviewPass(purchaseId);
    }

    @Override
    public void noReviewPass(int purchaseId) {
        drugStorageManage.noReviewPass(purchaseId);
    }

    @Override
    public void addDrug(Purchase purchase) {
        drugStorageManage.addDrug(purchase);
    }

    @Override
    public int drugStoreOut(List<DrugStoreOut> drugStoreOut) {
        return drugStorageManage.drugStoreOut(drugStoreOut);
    }

    @Override
    public PageInfo<DrugStoreOut> selectDrugStoreOut(String page, int size) {
        int page1=0;
        if(StringUtils.isEmpty(page)){
            page1 = Integer.parseInt(page="1");
        }else{
            page1 = Integer.parseInt(page);
        }
        //selectByUsers调用的是前面没分页的方法
        PageHelper.startPage(page1,size);
        List<DrugStoreOut> drugStoreOuts = drugStorageManage.selectDrugStoreOut();
        PageInfo<DrugStoreOut> phamacyReceiveList = new PageInfo<DrugStoreOut>(drugStoreOuts);
        return phamacyReceiveList;
    }

    @Override
    public void drugStoreOutDetele(int drugStoreOutId) {
        drugStorageManage.drugStoreOutDetele(drugStoreOutId);
    }

    @Override
    public void drugStoreOutReviewPass(int drugStoreOutId) {
        drugStorageManage.drugStoreOutReviewPass(drugStoreOutId);
    }

    @Override
    public void drugStoreOutNoReviewPass(int drugStoreOutId) {
        drugStorageManage.drugStoreOutNoReviewPass(drugStoreOutId);
    }

    @Override
    public void reduceDrug(DrugStoreOut drugStoreOut) {
        drugStorageManage.reduceDrug(drugStoreOut);

        if(drugStoreOut.getOutReason().contains("申领")) {
            DrugStore drugStore = drugStorageManage.selectDrug(drugStoreOut);
            drugStore.setDrugQuantity(drugStoreOut.getDrugQuantity());
            PhamacyDrug phamacyDrug = phamacyDrugManager.selectPhamacyDrug(drugStore.getDrugId());
            if (phamacyDrug != null) {
                int a = phamacyDrug.getDrugQuantity() + drugStore.getDrugQuantity();
                PhamacyReceive phamacyReceive = new PhamacyReceive();
                phamacyReceive.setPhamacyDrugQuantity(a);
                phamacyReceive.setPharmacyId(drugStore.getDrugId());
                phamacyDrugManager.phamacyDrugsBack(phamacyReceive);
            } else {
                phamacyDrugManager.addPharmacyDrugs(drugStore);
            }
        }

    }

    //查询所有简单表格
    @Override
    public PageInfo findAllDrugStore(int pageNum, int pagesize) {
        PageHelper.startPage(pageNum, pagesize);
        List<DrugStore> drugStoreList = drugStorageManage.findAllDrugStore();
        PageInfo<DrugStore> pageInfo = new PageInfo<DrugStore>(drugStoreList);
        return pageInfo;
    }

    //查询显示种类
    @Override
    public List<DrugClassification> findAllKindDrugStore() {
        List<DrugClassification> drugStoreList = drugStorageManage.findAllKindDrugStore();
        return drugStoreList;
    }

    @Override
    public List<DrugStore> findAllDrugStoreYearDetails(String drugName) {
        List<DrugStore> drugStoreList=drugStorageManage.findAllDrugStoreYearDetails(drugName);
        return drugStoreList;
    }



    //查询本周出库
    @Override
    public List<DrugStore> findAllDrugStoreWeekOutDetails(String drugName) {
        List<DrugStore> drugStoreList=drugStorageManage.findAllDrugStoreWeekOutDetails(drugName);
        return drugStoreList;

    }

    @Override
    public List<DrugStore> findAllDrugStoreMouthOutDetails(String drugName) {
        List<DrugStore> drugStoreList=drugStorageManage.findAllDrugStoreMouthOutDetails(drugName);
        return drugStoreList;

    }

    @Override
    public List<DrugStore> findAllDrugStoreYearInDetails(String drugName) {
        List<DrugStore> drugStoreList=drugStorageManage.findAllDrugStoreYearInDetails(drugName);
        return drugStoreList;

    }

    @Override
    public List<DrugStore> findAllDrugStoreWeekInDetails(String drugName) {
        List<DrugStore> drugStoreList=drugStorageManage.findAllDrugStoreWeekInDetails(drugName);
        return drugStoreList;
    }

    @Override
    public List<DrugStore> findAllDrugStoreMouthInDetails(String drugName) {
        List<DrugStore> drugStoreList=drugStorageManage.findAllDrugStoreMouthInDetails(drugName);
        return drugStoreList;
    }

    @Override
    public PageInfo findAllConditonDrugStore(int pageNum, int pagesize, String conditionQuery) {
        PageHelper.startPage(pageNum, pagesize);
        List<DrugStore> drugStoreList = drugStorageManage.findAllConditonDrugStore(conditionQuery);
        PageInfo<DrugStore> pageInfo = new PageInfo<DrugStore>(drugStoreList);
        return pageInfo;

    }


    //查询采购清单
    @Override
    public PageInfo findPurchase(int pageNum, int pagesize) {
        PageHelper.startPage(pageNum, pagesize);
        List<DrugStore> drugStoreList = drugStorageManage.findPurchase();
        PageInfo<DrugStore> pageInfo = new PageInfo<DrugStore>(drugStoreList);
        return pageInfo;
    }

    @Override
    public PageInfo findConditionPurchase(int pageNum, int pagesize, String conditionQuery) {
        PageHelper.startPage(pageNum, pagesize);
        List<DrugStore> drugStoreList = drugStorageManage.findConditionPurchase(conditionQuery);
        PageInfo<DrugStore> pageInfo = new PageInfo<DrugStore>(drugStoreList);
        return pageInfo;
    }


//
//    @Override
//    public List<DrugClassification> findAllBatchDrugStore(int drugClassificationId) {
//        List<DrugClassification>drugClassificationList=drugStorageManage.findAllBatchDrug(drugClassificationId);
//        return drugClassificationList;
//    }

    //查询出库
    @Override
    public PageInfo findAllSortDrugStore(int pageNum, int pagesize) {
        PageHelper.startPage(pageNum, pagesize);
        List<DrugStoreOutTable> drugStoreOutList = drugStorageManage.findAllSortDrugStore();
        PageInfo<DrugStoreOutTable> pageInfo = new PageInfo<DrugStoreOutTable>(drugStoreOutList);
        return pageInfo;
    }


    //查询入库
    @Override
    public PageInfo findAllBatchDrugStore(int pageNum, int pagesize) {
        PageHelper.startPage(pageNum, pagesize);
        List<DrugStore> drugStoreList = drugStorageManage.findAllBatchDrugStore();
        PageInfo<DrugStore> pageInfo = new PageInfo<DrugStore>(drugStoreList);
        return pageInfo;
    }

}
