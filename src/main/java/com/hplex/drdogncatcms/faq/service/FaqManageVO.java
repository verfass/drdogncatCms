package com.hplex.drdogncatcms.faq.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class FaqManageVO extends FaqDefaultVO {

    private static final long serialVersionUID = 8273395833507201519L;

    private String seq;
    private String faqType;
    private String faqSubject;
    private String faqContent;
    private String faqOrder;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String uptDttm;
    private String insUser;
    private String uptUser;

}
