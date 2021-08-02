package com.hplex.drdogncatcms.disease.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class DiseaseManageVO extends DiseaseDefaultVO {

    private static final long serialVersionUID = -9057306192221129698L;

    private String seq;
    private String diseaseName;
    private String diseaseDesc;
    private String diseaseCause;
    private String diseasePrevent;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String uptDttm;
    private String insUser;
    private String uptUser;
}
