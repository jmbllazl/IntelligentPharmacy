package com.cy.mapper;

import com.cy.bean.*;
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
    public ArrayList<Purchase> selectPhamacyReceivePageInfo();

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
    public int drugStoreOut(@Param("drugStoreOutList")List<DrugStoreOut> drugStoreOut);

    //药库药品退还厂家审核单
    public ArrayList<DrugStoreOut> selectDrugStoreOut();

    //删除退还厂家单中某条数据
    public void drugStoreOutDetele(int drugStoreOutId);

    //通过审核
    public void drugStoreOutReviewPass(int drugStoreOutId);

    //不通过审核
    public void drugStoreOutNoReviewPass(int drugStoreOutId);

    //通过审核减少库存
    public void reduceDrug(DrugStoreOut drugStoreOut);
    
    //通过药品名查询药品
    public DrugStore selectDrug (DrugStoreOut drugStoreOut);
    //查询所有药库出入库明细
    public List<DrugStore> findAllDrugStore();
    //查询出库的明细
    public List<DrugStoreOutTable> findAllSortDrugStore();
    //查询入库明细表
    public List<DrugStore> findAllBatchDrugStore();
    //查询初始化种类
    public List<DrugClassification> findAllKindDrugStore();
    //查询种类生成编号
    public List<DrugClassification>findAllBatchDrug(int drugClassificationId);
    //    //查询药品详情
    public List<DrugStore> findAllDrugStoreYearDetails(String drugName );
    //查询药品出库本周
    public  List<DrugStore> findAllDrugStoreWeekOutDetails(String drugName);
    //查询药品本月出库
    public  List<DrugStore> findAllDrugStoreMouthOutDetails(String drugName);
    //    //查询药品详情
    public List<DrugStore> findAllDrugStoreYearInDetails(String drugName );

    //查询药品出库本周
    public  List<DrugStore> findAllDrugStoreWeekInDetails(String drugName);
    //查询药品本月出库
    public  List<DrugStore> findAllDrugStoreMouthInDetails(String drugName);
    //条件查询
    public List<DrugStore> findAllConditonDrugStore(String conditionQuery);
    //查询采购清单
    public List<DrugStore> findPurchase();
    //条件查询
    public  List<DrugStore> findConditionPurchase(String conditionQuery);
}
