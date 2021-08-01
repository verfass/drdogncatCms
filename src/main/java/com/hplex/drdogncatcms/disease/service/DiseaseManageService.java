package com.hplex.drdogncatcms.disease.service;

import java.util.List;

public interface DiseaseManageService {

    // select list
    public List<DiseaseManageVO> selectDiseaseList() throws Exception;

    // select one
    public DiseaseManageVO selectDisease(String seq) throws Exception;

    // update one

}
