package com.hplex.drdogncatcms.inquiry.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class InquiryTypeManageVO extends InquiryTypeDefaultVO {

    private static final long serialVersionUID = -964924244025815243L;

    private String seq;
    private String inquiryType;

}
