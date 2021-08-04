package com.hplex.drdogncatcms.disease.service;

import java.util.List;

public interface DiseaseManageService {

    // select list
    public List<?> selectDiseaseList(DiseaseDefaultVO diseaseSearchVO) throws Exception;

    // select one
    public DiseaseManageVO selectDisease(String seq) throws Exception;

    // update one
    public void updateDisease(DiseaseManageVO diseaseManageVO) throws Exception;

    // insert one
    public void insertDisease(DiseaseManageVO diseaseManageVO) throws Exception;

}
