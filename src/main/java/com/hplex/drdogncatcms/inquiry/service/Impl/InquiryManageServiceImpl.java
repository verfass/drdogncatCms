package com.hplex.drdogncatcms.inquiry.service.Impl;

import com.hplex.drdogncatcms.inquiry.service.InquiryDefaultVO;
import com.hplex.drdogncatcms.inquiry.service.InquiryManageService;
import com.hplex.drdogncatcms.inquiry.service.InquiryManageVO;
import com.hplex.drdogncatcms.inquiry.service.InquiryTypeDefaultVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("inquiryManageService")
@Log4j2
@AllArgsConstructor
public class InquiryManageServiceImpl implements InquiryManageService {

    @Autowired
    private InquiryManageDAO inquiryManageDAO;

    // select list
    @Override
    public List<?> selectInquiryList(InquiryDefaultVO inquirySearchVO) throws Exception {
        return inquiryManageDAO.selectInquiryList(inquirySearchVO);
    }

    // select one
    @Override
    public InquiryManageVO selectInquiry(String seq) throws Exception {
        return inquiryManageDAO.selectInquiry(seq);
    }

    // insert one
    @Override
    public int insertInquiry(InquiryManageVO inquiryManageVO) throws Exception {
        return inquiryManageDAO.insertInquiry(inquiryManageVO);
    }

    // update one
    @Override
    public void updateInquiry(InquiryManageVO inquiryManageVO) throws Exception {
        inquiryManageDAO.updateInquiry(inquiryManageVO);
    }

    // delete one
    @Override
    public void deleteInquiry(String itemId) throws Exception {
        inquiryManageDAO.deleteInquiry(itemId);
    }



    // select list
    @Override
    public List<?> selectInquiryTypeList(InquiryTypeDefaultVO inquiryTypeSearchVO) throws Exception {
        return inquiryManageDAO.selectInquiryTypeList(inquiryTypeSearchVO);
    }
}
