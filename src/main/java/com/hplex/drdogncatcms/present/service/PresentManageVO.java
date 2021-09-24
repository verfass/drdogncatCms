package com.hplex.drdogncatcms.present.service;

import com.hplex.drdogncatcms.present.service.PresentDefaultVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class PresentManageVO extends PresentDefaultVO {

    private static final long serialVersionUID = -3407759472136774862L;

    private String seq;
    private String memberSeq;
    private String petId;
    private String presentGubun;
    private String expirationDt;
    private String challengeId;
    private String presentType;
    private String presentCode;
    private String presentName;
    private String presentNum;
    private String reviewLink;
    private String receiveName;
    private String receivePhonenumber;
    private String receivePost;
    private String receiveAddress1;
    private String receiveAddress2;
    private String deliveryMemo;
    private String deliveryCode;
    private String deliverySearch;
    private String stateStep;
    private String rejectCode;
    private String rejectMemo;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String uptDttm;
    private String checkUser;
    private String checkDttm;


}
