package com.hplex.drdogncatcms.disease.service.Impl;

import com.hplex.drdogncatcms.disease.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("diseaseRefManageService")
@Log4j2
@AllArgsConstructor
public class DiseaseRefManageServiceImpl implements DiseaseRefManageService {

    @Autowired
    private DiseaseRefManageDAO diseaseRefManageDAO;

    // select list
    @Override
    public List<?> selectDiseaseRefList(DiseaseRefDefaultVO diseaseRefSearchVO) throws Exception {
        return diseaseRefManageDAO.selectDiseaseRefList(diseaseRefSearchVO);
    }

    // select one
    @Override
    public DiseaseRefManageVO selectDiseaseRef(String seq) throws Exception {
        return diseaseRefManageDAO.selectDiseaseRef(seq);
    }

    // select one
    @Override
    public Integer selectDiseaseCnt(String itemId, String diseaseId) throws Exception {
        HashMap map = new HashMap();
        map.put("itemId", itemId);
        map.put("diseaseId", diseaseId);

        Integer result = diseaseRefManageDAO.selectDiseaseCnt(map);
        return result;
    }

    // insert one
    @Override
    public int insertDiseaseRef(DiseaseRefManageVO diseaseRefManageVO) throws Exception {
        return diseaseRefManageDAO.insertDiseaseRef(diseaseRefManageVO);
    }

    // delete one
    @Override
    public void deleteDiseaseRef(String itemId) throws Exception {
        diseaseRefManageDAO.deleteDiseaseRef(itemId);
    }

}
