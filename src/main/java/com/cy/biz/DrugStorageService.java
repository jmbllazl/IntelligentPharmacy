package com.cy.biz;

import com.cy.bean.DrugStore;
import com.cy.bean.PhamacyDrug;
import com.cy.bean.Purchase;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DrugStorageService {

    //添加采购药品
    public void DrugPurchase(DrugStore phamacyDrug);
    //通过药品分类查询药品
    public PageInfo<DrugStore> selectDrugStore(int drugClassificationId,String page,int size);
    //增加采购单
    public int addPurchase(List<Purchase> purchase);
    //药库药品采购审核单
    public PageInfo<Purchase> selectPhamacyReceivePageInfo(Map<String, Object> map, String page, int size);

}
