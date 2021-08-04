package com.hplex.drdogncatcms.disease.service.Impl;

import com.hplex.drdogncatcms.disease.service.DiseaseDefaultVO;
import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiseaseManageDAO {

    // select list
    public List<?> selectDiseaseList(DiseaseDefaultVO diseaseSearchVO);

    // select one
    public DiseaseManageVO selectDisease(String seq);

    // update one
    public void updateDisease(DiseaseManageVO diseaseManageVO);

    // insert one
    public void insertDisease(DiseaseManageVO diseaseManageVO);
}
