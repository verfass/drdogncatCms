package com.hplex.drdogncatcms.inquiry.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class InquiryManageVO extends InquiryDefaultVO {

    private static final long serialVersionUID = -2619921318911777043L;

    private String seq;
    private String memberSeq;
    private String inquiryType;
    private String inquirySubject;
    private String inquiryContent;
    private String inquiryImgs;
    private String answerAt;
    private String answerContent;
    private String answerDttm;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String uptDttm;


}
