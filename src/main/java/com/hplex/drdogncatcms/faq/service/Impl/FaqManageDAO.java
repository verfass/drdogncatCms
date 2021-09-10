package com.hplex.drdogncatcms.faq.service.Impl;

import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;
import com.hplex.drdogncatcms.faq.service.FaqDefaultVO;
import com.hplex.drdogncatcms.faq.service.FaqManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface FaqManageDAO {

    // select list
    public List<?> selectFaqList(FaqDefaultVO faqSearchVO);

    // select one
    public FaqManageVO selectFaq(String seq);

    // insert one
    public int insertFaq(FaqManageVO faqManageVO);

    // update one
    public void updateFaq(FaqManageVO faqManageVO);

    // delete one
    public void deleteFaq(String itemId);

}
