package com.hplex.drdogncatcms.member.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class MemberManageVO extends MemberDefaultVO {

    private static final long serialVersionUID = -7768059994520459747L;

    private String seq;
    private String phoneNumber;
    private String memberEmail;
    private String memberPass;
    private String memberName;
    private String memberCode;
    private String refereeCode;
    private String socialKakaoId;
    private String socialNaverId;
    private String socialAppleId;
    private String marketingAgree;
    private String memberState;
    private String petId;
    private String joinDttm;
    private String refereeDttm;
    private String withdrawDttm;
    private String connectDttm;
    private String marketingDttm;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String uptDttm;
    private String insUser;
    private String uptUser;

}
