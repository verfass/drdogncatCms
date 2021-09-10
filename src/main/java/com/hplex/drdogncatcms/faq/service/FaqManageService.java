package com.hplex.drdogncatcms.faq.service;

import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;
import com.hplex.drdogncatcms.disease.service.DiseaseRefDefaultVO;
import com.hplex.drdogncatcms.disease.service.DiseaseRefManageVO;

import java.util.List;

public interface FaqManageService {

    // select list
    public List<?> selectFaqList(FaqDefaultVO faqSearchVO) throws Exception;

    // select one
    public FaqManageVO selectFaq(String seq) throws Exception;

    // insert one
    public int insertFaq(FaqManageVO faqManageVO) throws Exception;

    // update one
    public void updateFaq(FaqManageVO faqManageVO) throws Exception;

    // delete one
    public void deleteFaq(String itemId) throws Exception;

}
