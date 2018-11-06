package com.cy.mapper;

import com.cy.bean.DrugStore;
import com.cy.bean.PhamacyDrug;
import com.cy.bean.PhamacyReceive;
import com.cy.bean.Purchase;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("drugStorageManage")
public interface DrugStorageManage {

    //添加采购药品
    public void DrugPurchase(DrugStore drugStore);

    //通过药品分类查询药品
    public ArrayList<DrugStore> selectDrugStore(int drugClassificationId);

    //增加采购单
    public int addPurchase(@Param("purchaseList")List<Purchase> purchase);

    //药库药品采购审核单
    public PageInfo<Purchase> selectPhamacyReceivePageInfo(Map<String, Object> map);

}
