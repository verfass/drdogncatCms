package com.hplex.drdogncatcms.disease.service.Impl;

import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiseaseManageDAO {

    // select list
    public List<DiseaseManageVO> selectDiseaseList();

    // select one
    public DiseaseManageVO selectDisease(String seq);

    // update one
    public void updateDisease(DiseaseManageVO diseaseManageVO);
}
