package com.cy.mapper;import com.cy.bean.DrugClassification;import com.cy.bean.PhamacyDrug;import org.springframework.stereotype.Repository;import java.util.List;import java.util.Map;@Repositorypublic interface PhamacyDrugManager {    public List<PhamacyDrug> selectAllPhamacyDrug(Map<String, Object> map);    public int delectPhamacyDrug(int pharmacyId);    public PhamacyDrug selectPhamacyDrug(int pharmacyId );    public List<DrugClassification> selectAllDrugClassification();    public List<PhamacyDrug> selectDrugClassificationPhamacyDrug(int drugClassificationId);}