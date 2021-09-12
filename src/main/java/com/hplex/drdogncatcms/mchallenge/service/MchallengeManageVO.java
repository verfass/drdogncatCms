package com.hplex.drdogncatcms.mchallenge.service;

import com.hplex.drdogncatcms.mchallenge.service.MchallengeDefaultVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class MchallengeManageVO extends MchallengeDefaultVO {

    private static final long serialVersionUID = 3809056713273365548L;

    private String seq;
    private String memberSeq;
    private String petId;
    private String challengeId;
    private String categoryId;
    private String checkupGubun;
    private String resultId;
    private String score;
    private String completeAt;
    private String chkAt;
    private String delAt;
    private String insDttm;

}
