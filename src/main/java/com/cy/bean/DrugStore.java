package com.cy.bean;


import org.springframework.stereotype.Service;

/**
 * 药库药品表
 *
 **/
@Service
public class DrugStore {

    private int drugId; //药品ID
    private int drugClassificationId;//药品分类ID
    private int purchaseId;//采购ID
    private int drugStoreOutId;//药库出库ID
    private int drugNumber;//药品编号
    private String drugName;//药品品名
    private String drugDetails;//药品详情
    private String formulation;//剂型
    private String norm;//规格
    private String unit;//单位
    private int drugPrice;//药品价格
    private int drugQuantity;//数量
    private String approvalnumber;//批注文号
    private String produtionDate;//生产日期
    private String lotNumber;//批号
    private String validaityperiod;//有效期
    private String manufacturer;//生产产商
    private String drugIdState;//药品状态
    private int medicalinsurance;//医保药品
    private String storageTime;//药品入库日期
    private String drugPhoto;//药品图片存放路径
    private String dayConsumption;//每日用量
    private String drugClassificationName;//药品种类名称
    private int state;//查询状态
    private String receivedate;//出库日期
    private int outCount;//出库数量
    private int inCount;//入库数量


    public DrugStore() {
    }

    public DrugStore(int drugId, int drugClassificationId, int purchaseId, int drugStoreOutId, int drugNumber, String drugName, String drugDetails, String formulation, String norm, String unit, int drugPrice, int drugQuantity, String approvalnumber, String produtionDate, String lotNumber, String validaityperiod, String manufacturer, String drugIdState, int medicalinsurance, String storageTime,
                     String drugPhoto, String dayConsumption, String drugClassificationName, int state) {
        this.drugId = drugId;
        this.drugClassificationId = drugClassificationId;
        this.purchaseId = purchaseId;
        this.drugStoreOutId = drugStoreOutId;
        this.drugNumber = drugNumber;
        this.drugName = drugName;
        this.drugDetails = drugDetails;
        this.formulation = formulation;
        this.norm = norm;
        this.unit = unit;
        this.drugPrice = drugPrice;
        this.drugQuantity = drugQuantity;
        this.approvalnumber = approvalnumber;
        this.produtionDate = produtionDate;
        this.lotNumber = lotNumber;
        this.validaityperiod = validaityperiod;
        this.manufacturer = manufacturer;
        this.drugIdState = drugIdState;
        this.medicalinsurance = medicalinsurance;
        this.storageTime = storageTime;
        this.drugPhoto = drugPhoto;
        this.dayConsumption = dayConsumption;
        this.drugClassificationName = drugClassificationName;
        this.state = state;
    }

    public DrugStore(int drugId, int drugClassificationId, int purchaseId, int drugStoreOutId, int drugNumber, String drugName, String drugDetails, String formulation, String norm, String unit, int drugPrice, int drugQuantity, String approvalnumber, String produtionDate, String lotNumber, String validaityperiod, String manufacturer, String drugIdState, int medicalinsurance, String storageTime, String drugPhoto, String dayConsumption, String drugClassificationName, int state, String receivedate) {
        this.drugId = drugId;
        this.drugClassificationId = drugClassificationId;
        this.purchaseId = purchaseId;
        this.drugStoreOutId = drugStoreOutId;
        this.drugNumber = drugNumber;
        this.drugName = drugName;
        this.drugDetails = drugDetails;
        this.formulation = formulation;
        this.norm = norm;
        this.unit = unit;
        this.drugPrice = drugPrice;
        this.drugQuantity = drugQuantity;
        this.approvalnumber = approvalnumber;
        this.produtionDate = produtionDate;
        this.lotNumber = lotNumber;
        this.validaityperiod = validaityperiod;
        this.manufacturer = manufacturer;
        this.drugIdState = drugIdState;
        this.medicalinsurance = medicalinsurance;
        this.storageTime = storageTime;
        this.drugPhoto = drugPhoto;
        this.dayConsumption = dayConsumption;
        this.drugClassificationName = drugClassificationName;
        this.state = state;
        this.receivedate = receivedate;
    }

    public DrugStore(int drugId, int drugClassificationId, int purchaseId, int drugStoreOutId, int drugNumber, String drugName, String drugDetails, String formulation, String norm, String unit, int drugPrice, int drugQuantity, String approvalnumber, String produtionDate, String lotNumber, String validaityperiod, String manufacturer, String drugIdState, int medicalinsurance, String storageTime, String drugPhoto, String dayConsumption, String drugClassificationName, int state, String receivedate, int outCount, int inCount) {
        this.drugId = drugId;
        this.drugClassificationId = drugClassificationId;
        this.drugNumber = drugNumber;
        this.drugDetails = drugDetails;
        this.formulation = formulation;
        this.norm = norm;
        this.unit = unit;
        this.drugPrice = drugPrice;
        this.drugQuantity = drugQuantity;
        this.approvalnumber = approvalnumber;
        this.produtionDate = produtionDate;
        this.lotNumber = lotNumber;
        this.validaityperiod = validaityperiod;
        this.manufacturer = manufacturer;
        this.drugIdState = drugIdState;
        this.medicalinsurance = medicalinsurance;
        this.storageTime = storageTime;
        this.drugPhoto = drugPhoto;
        this.dayConsumption = dayConsumption;
        this.drugClassificationName = drugClassificationName;
        this.state = state;
        this.receivedate = receivedate;
        this.outCount = outCount;
        this.inCount = inCount;
    }

    public DrugStore(String drugName, int drugNumber, int drugClass, String drugDetailed, String formUlarion, String norm, String unit, int drugPrice, String approvalNumber, String produtionDate, String lotNumber, String validaiTypeRiod, String manufacTurer, String storageTime, String drugPhoto, String dayConsumption) {

        this.drugNumber = drugNumber;
        this.drugName = drugName;
        this.norm = norm;
        this.unit = unit;
        this.drugPrice = drugPrice;
        this.produtionDate = produtionDate;
        this.lotNumber = lotNumber;

        this.storageTime = storageTime;
        this.drugPhoto = drugPhoto;
        this.dayConsumption = dayConsumption;

    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public int getDrugClassificationId() {
        return drugClassificationId;
    }

    public void setDrugClassificationId(int drugClassificationId) {
        this.drugClassificationId = drugClassificationId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getDrugStoreOutId() {
        return drugStoreOutId;
    }

    public void setDrugStoreOutId(int drugStoreOutId) {
        this.drugStoreOutId = drugStoreOutId;
    }

    public int getDrugNumber() {
        return drugNumber;
    }

    public void setDrugNumber(int drugNumber) {
        this.drugNumber = drugNumber;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugDetails() {
        return drugDetails;
    }

    public void setDrugDetails(String drugDetails) {
        this.drugDetails = drugDetails;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public String getNorm() {
        return norm;
    }

    public void setNorm(String norm) {
        this.norm = norm;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(int drugPrice) {
        this.drugPrice = drugPrice;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public String getApprovalnumber() {
        return approvalnumber;
    }

    public void setApprovalnumber(String approvalnumber) {
        this.approvalnumber = approvalnumber;
    }

    public String getProdutionDate() {
        return produtionDate;
    }

    public void setProdutionDate(String produtionDate) {
        this.produtionDate = produtionDate;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getValidaityperiod() {
        return validaityperiod;
    }

    public void setValidaityperiod(String validaityperiod) {
        this.validaityperiod = validaityperiod;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDrugIdState() {
        return drugIdState;
    }

    public void setDrugIdState(String drugIdState) {
        this.drugIdState = drugIdState;
    }

    public int getMedicalinsurance() {
        return medicalinsurance;
    }

    public void setMedicalinsurance(int medicalinsurance) {
        this.medicalinsurance = medicalinsurance;
    }

    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime;
    }

    public String getDrugPhoto() {
        return drugPhoto;
    }

    public void setDrugPhoto(String drugPhoto) {
        this.drugPhoto = drugPhoto;
    }

    public DrugStore(String dayConsumption) {
        this.dayConsumption = dayConsumption;
    }

    public String getDayConsumption() {
        return dayConsumption;
    }

    public void setDayConsumption(String dayConsumption) {
        this.dayConsumption = dayConsumption;
    }

    public String getDrugClassificationName() {
        return drugClassificationName;
    }

    public void setDrugClassificationName(String drugClassificationName) {
        this.drugClassificationName = drugClassificationName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(String receivedate) {
        this.receivedate = receivedate;
    }

    public int getOutCount() {
        return outCount;
    }

    public void setOutCount(int outCount) {
        this.outCount = outCount;
    }

    public int getInCount() {
        return inCount;
    }

    public void setInCount(int inCount) {
        this.inCount = inCount;
    }
}
