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
public class DrugStorageServiceImp implements DrugStorageService{

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
        DrugStore drugStore = drugStorageManage.selectDrug(drugStoreOut);
        drugStore.setDrugQuantity(drugStoreOut.getDrugQuantity());
        phamacyDrugManager.addPharmacyDrugs(drugStore);
       
    }


}
