package com.hplex.drdogncatcms.inform.service;

import com.hplex.drdogncatcms.inform.service.InformDefaultVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class InformManageVO extends InformDefaultVO {

    private static final long serialVersionUID = 8879042812412784192L;

    private String seq;
    private String memberSeq;
    private String informTitle;
    private String informContent;
    private String informLink;
    private String confirmAt;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String confirmDttm;

}
