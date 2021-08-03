package com.hplex.drdogncatcms.disease.service.Impl;

import com.hplex.drdogncatcms.disease.service.DiseaseDefaultVO;
import com.hplex.drdogncatcms.disease.service.DiseaseRefDefaultVO;
import com.hplex.drdogncatcms.disease.service.DiseaseRefManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface DiseaseRefManageDAO {

    // select list
    public List<?> selectDiseaseRefList(DiseaseRefDefaultVO diseaseRefSearchVO);

    // select one
    public DiseaseRefManageVO selectDiseaseRef(String seq);

    // select cnt
    public Integer selectDiseaseCnt(HashMap<String, String> map);

    // insert one
    public int insertDiseaseRef(DiseaseRefManageVO diseaseRefManageVO);

    // delete one
    public void deleteDiseaseRef(String itemId);
}
