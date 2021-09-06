package com.hplex.drdogncatcms.mcheckup.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class McheckupManageVO extends McheckupDefaultVO {

    private static final long serialVersionUID = 6734497034816607916L;

    private String seq;
    private String memberSeq;
    private String modelName;
    private String gubunCode;
    private String petId;
    private String checkupGubun;
    private String categoryId;
    private String itemId;
    private String challengeId;
    private String targetRed;
    private String targetGreen;
    private String targetBlue;
    private String targetRed2;
    private String targetGreen2;
    private String targetBlue2;
    private String whiteRed;
    private String whiteGreen;
    private String whiteBlue;
    private String whiteRed2;
    private String whiteGreen2;
    private String whiteBlue2;
    private String colorDiff;
    private String colormetricNum;
    private String judgmentVal;
    private String judgmentLabel;
    private String judgmentRet;
    private String chkAt;
    private String delAt;
    private String insDttm;

}
