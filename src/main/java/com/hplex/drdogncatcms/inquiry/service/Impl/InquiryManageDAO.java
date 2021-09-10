package com.hplex.drdogncatcms.inquiry.service.Impl;

import com.hplex.drdogncatcms.inquiry.service.InquiryDefaultVO;
import com.hplex.drdogncatcms.inquiry.service.InquiryManageVO;
import com.hplex.drdogncatcms.inquiry.service.InquiryTypeDefaultVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InquiryManageDAO {

    // select list
    public List<?> selectInquiryList(InquiryDefaultVO inquirySearchVO);

    // select one
    public InquiryManageVO selectInquiry(String seq);

    // insert one
    public int insertInquiry(InquiryManageVO inquiryManageVO);

    // update one
    public void updateInquiry(InquiryManageVO inquiryManageVO);

    // delete one
    public void deleteInquiry(String itemId);



    // select list
    public List<?> selectInquiryTypeList(InquiryTypeDefaultVO inquiryTypeSearchVO);
}
