package com.hplex.drdogncatcms.challenge.service;

import com.hplex.drdogncatcms.challenge.service.ChallengeDefaultVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ChallengeManageVO extends ChallengeDefaultVO {

    private static final long serialVersionUID = -4962590887202352339L;

    private String seq;
    private String categoryId;
    private String challengeGubun;
    private String challengeTitle;
    private String startMon;
    private String endMon;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String insUser;
    private String uptDttm;
    private String uptUser;


}
