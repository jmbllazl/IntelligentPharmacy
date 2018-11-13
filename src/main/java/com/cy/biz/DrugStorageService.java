package com.cy.biz;

import com.cy.bean.*;
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
    public PageInfo<Purchase> selectPhamacyReceivePageInfo(String page, int size);
    //通过药品ID查药品名
    public String drugName(int drugId);
    //删除采购单中某条数据
    public void purchaseDetele(int drugId);
    //通过审核
    public void reviewPass(int purchaseId);
    //不通过审核
    public void noReviewPass(int purchaseId);
    //通过审核增加库存
    public void addDrug(Purchase purchase);
    //增加退库单
    public int drugStoreOut(List<DrugStoreOut> drugStoreOut);
    //药库药品退还厂家审核单
    public PageInfo<DrugStoreOut> selectDrugStoreOut(String page, int size);
    //删除退还厂家单中某条数据
    public void drugStoreOutDetele(int drugStoreOutId);
    //通过审核
    public void drugStoreOutReviewPass(int drugStoreOutId);
    //不通过审核
    public void drugStoreOutNoReviewPass(int drugStoreOutId);
    //通过审核减少库存
    public void reduceDrug(DrugStoreOut drugStoreOut);
    //查询所有药库出入库明细
    public PageInfo findAllDrugStore(int pageNum, int pagesize);

    //查询种类的明细
    public PageInfo findAllSortDrugStore(int pageNum, int pagesize);

    //查询批次明细表
    public PageInfo findAllBatchDrugStore(int pageNum, int pagesize);

    //查询所有种类一遍ajax根据显示种类
    public List<DrugClassification> findAllKindDrugStore();
    //
//    //查询药品详情
    public List<DrugStore> findAllDrugStoreYearDetails(String drugName );

    //查询药品本周
    public  List<DrugStore> findAllDrugStoreWeekOutDetails(String drugName);
    //查询药品出库本周
    public  List<DrugStore> findAllDrugStoreMouthOutDetails(String drugName);
    //    //查询药品详情
    public List<DrugStore> findAllDrugStoreYearInDetails(String drugName );
    //查询药品本周
    public  List<DrugStore> findAllDrugStoreWeekInDetails(String drugName);
    //查询药品出库本周
    public  List<DrugStore> findAllDrugStoreMouthInDetails(String drugName);
    //条件查询
    public PageInfo findAllConditonDrugStore(int pageNum, int pagesize,String conditionQuery);
    //查询采购清单
    public  PageInfo findPurchase(int pageNum, int pagesize);
    //条件查询
    public  PageInfo findConditionPurchase(int pageNum, int pagesize, String conditionQuery);

}
