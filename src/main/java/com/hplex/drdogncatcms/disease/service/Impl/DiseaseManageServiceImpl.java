package com.hplex.drdogncatcms.disease.service.Impl;

import com.hplex.drdogncatcms.checkup.service.Impl.ItemManageDAO;
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
    public List<DiseaseManageVO> selectDiseaseList() throws Exception {
        return diseaseManageDAO.selectDiseaseList();
    }

    // select one
    public DiseaseManageVO selectDisease(String seq) throws Exception {
        return diseaseManageDAO.selectDisease(seq);
    }

    // update one

}
