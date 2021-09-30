package com.hplex.drdogncatcms.disease.service.Impl;

import com.hplex.drdogncatcms.disease.service.DiseaseDefaultVO;
import com.hplex.drdogncatcms.disease.service.DiseaseManageService;
import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("diseaseManageService")
@Log4j2
@AllArgsConstructor
public class DiseaseManageServiceImpl implements DiseaseManageService {

    @Autowired
    private DiseaseManageDAO diseaseManageDAO;

    // select list
    @Override
    public List<?> selectDiseaseList(DiseaseDefaultVO diseaseSearchVO) throws Exception {
        return diseaseManageDAO.selectDiseaseList(diseaseSearchVO);
    }

    // select one
    @Override
    public DiseaseManageVO selectDisease(String seq) throws Exception {
        return diseaseManageDAO.selectDisease(seq);
    }

    // update one
    @Override
    public void updateDisease(DiseaseManageVO diseaseManageVO) throws Exception {
        diseaseManageDAO.updateDisease(diseaseManageVO);
    }

    // insert one
    @Override
    public void insertDisease(DiseaseManageVO diseaseManageVO) throws Exception {
        diseaseManageDAO.insertDisease(diseaseManageVO);
    }

    // delete one
    @Override
    public void deleteDisease(DiseaseManageVO diseaseManageVO) throws Exception {
        diseaseManageDAO.deleteDisease(diseaseManageVO);
    }
}
