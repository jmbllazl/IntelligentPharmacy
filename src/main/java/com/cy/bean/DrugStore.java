package com.cy.bean;


/**
 * 药库药品表
 *
 **/
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

    public DrugStore() {
    }

    public DrugStore(int drugId, int drugClassificationId, int purchaseId, int drugStoreOutId, int drugNumber, String drugName, String drugDetails, String formulation, String norm, String unit, int drugPrice, int drugQuantity, String approvalnumber, String produtionDate, String lotNumber, String validaityperiod, String manufacturer, String drugIdState, int medicalinsurance, String storageTime, String drugPhoto) {
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
    }

    public DrugStore( String drugName,int drugClassificationId, int drugNumber, String drugDetails, String formulation, String norm, String unit, int drugPrice, int drugQuantity, String approvalnumber, String produtionDate, String lotNumber, String validaityperiod, String manufacturer, String storageTime, String drugPhoto) {

        this.drugName = drugName;
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
        this.storageTime = storageTime;
        this.drugPhoto = drugPhoto;
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
}
