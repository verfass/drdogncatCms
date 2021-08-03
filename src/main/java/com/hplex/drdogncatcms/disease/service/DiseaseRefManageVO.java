package com.hplex.drdogncatcms.disease.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class DiseaseRefManageVO extends DiseaseRefDefaultVO {

    private static final long serialVersionUID = -9135696345170027686L;

    private String seq;
    private String itemId;
    private String diseaseId;
    private String diseaseName;

}
