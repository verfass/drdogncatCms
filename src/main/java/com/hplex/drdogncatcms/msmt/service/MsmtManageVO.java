package com.hplex.drdogncatcms.msmt.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class MsmtManageVO extends MsmtDefaultVO {

    private static final long serialVersionUID = -605777722400908279L;

    private String id;
    private String categoryId;
    private String itemId;
    private String envGubun;
    private String colorDiffMin;
    private String colorDiffMax;
    private String colorMetricsNum;
    private String judgmentVal;
    private String judgmentLabel;
    private String judgmentRet;
    private String ord;
    private String chkAt;
    private String delAt;
    private String insUser;
    private String uptUser;
    private String insDttm;
    private String uptDttm;

}
