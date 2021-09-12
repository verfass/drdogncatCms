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

    private static final long serialVersionUID = -1390939010587949531L;

    private String seq;
    private String presentName;
    private String presentPrice;
    private String presentImg;
    private String presentLink;
    private String presentOrd;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String uptDttm;

}
