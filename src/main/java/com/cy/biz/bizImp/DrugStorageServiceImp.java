package com.cy.biz.bizImp;

import com.cy.bean.DrugStore;
import com.cy.bean.PhamacyDrug;
import com.cy.bean.PhamacyReceive;
import com.cy.bean.Purchase;
import com.cy.biz.DrugStorageService;
import com.cy.mapper.DrugStorageManage;
import com.cy.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DrugStorageServiceImp implements DrugStorageService {

    @Resource
    DrugStorageManage drugStorageManage;
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
    public PageInfo<Purchase> selectPhamacyReceivePageInfo(Map<String, Object> map, String page, int size) {
        int page1=0;
        if(StringUtils.isEmpty(page)){
            page1 = Integer.parseInt(page="1");
        }else{
            page1 = Integer.parseInt(page);
        }
        //selectByUsers调用的是前面没分页的方法
        PageHelper.startPage(page1,size);
        List<Purchase> phamacyReceiveListPageInfo = (List<Purchase>) drugStorageManage.selectPhamacyReceivePageInfo(map);
        PageInfo<Purchase> phamacyReceiveList = new PageInfo<Purchase>(phamacyReceiveListPageInfo);
        return phamacyReceiveList;
    }


}
