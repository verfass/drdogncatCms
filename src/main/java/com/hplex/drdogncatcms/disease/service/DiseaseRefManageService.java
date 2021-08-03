package com.hplex.drdogncatcms.disease.service;

import java.util.List;

public interface DiseaseRefManageService {

    // select list
    public List<?> selectDiseaseRefList(DiseaseRefDefaultVO diseaseRefSearchVO) throws Exception;

    // select one
    public DiseaseRefManageVO selectDiseaseRef(String seq) throws Exception;

    // select cnt
    public Integer selectDiseaseCnt(String itemId, String diseaseId) throws Exception;

    // insert one
    public int insertDiseaseRef(DiseaseRefManageVO diseaseRefManageVO) throws Exception;

    // delete one
    public void deleteDiseaseRef(String itemId) throws Exception;
}
