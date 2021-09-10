package com.hplex.drdogncatcms.inquiry.service;

import java.util.List;

public interface InquiryManageService {

    // select list
    public List<?> selectInquiryList(InquiryDefaultVO inquirySearchVO) throws Exception;

    // select one
    public InquiryManageVO selectInquiry(String seq) throws Exception;

    // insert one
    public int insertInquiry(InquiryManageVO inquiryManageVO) throws Exception;

    // update one
    public void updateInquiry(InquiryManageVO inquiryManageVO) throws Exception;

    // delete one
    public void deleteInquiry(String itemId) throws Exception;



    // select list
    public List<?> selectInquiryTypeList(InquiryTypeDefaultVO inquiryTypeSearchVO) throws Exception;

}
