package com.hplex.drdogncatcms.faq.service.Impl;

import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;
import com.hplex.drdogncatcms.faq.service.FaqDefaultVO;
import com.hplex.drdogncatcms.faq.service.FaqManageService;
import com.hplex.drdogncatcms.faq.service.FaqManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("faqManageService")
@Log4j2
@AllArgsConstructor
public class FaqManageServiceImpl implements FaqManageService {

    @Autowired
    private FaqManageDAO faqManageDAO;

    // select list
    @Override
    public List<?> selectFaqList(FaqDefaultVO faqSearchVO) throws Exception {
        return faqManageDAO.selectFaqList(faqSearchVO);
    }

    // select one
    @Override
    public FaqManageVO selectFaq(String seq) throws Exception {
        return faqManageDAO.selectFaq(seq);
    }

    // insert one
    @Override
    public int insertFaq(FaqManageVO faqManageVO) throws Exception {
        return faqManageDAO.insertFaq(faqManageVO);
    }

    // update one
    @Override
    public void updateFaq(FaqManageVO faqManageVO) throws Exception {
        faqManageDAO.updateFaq(faqManageVO);
    }

    // delete one
    @Override
    public void deleteFaq(String itemId) throws Exception {
        faqManageDAO.deleteFaq(itemId);
    }
}
