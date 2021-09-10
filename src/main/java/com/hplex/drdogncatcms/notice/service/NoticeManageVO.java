package com.hplex.drdogncatcms.notice.service;

import com.hplex.drdogncatcms.inquiry.service.InquiryDefaultVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class NoticeManageVO extends NoticeDefaultVO {

    private static final long serialVersionUID = 4017356443927813588L;

    private String seq;
    private String noticeSubject;
    private String noticeContent;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String uptDttm;
    private String insUser;
    private String uptUser;

}
