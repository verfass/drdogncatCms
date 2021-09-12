package com.hplex.drdogncatcms.product.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductManageVO extends ProductDefaultVO {

    private static final long serialVersionUID = 4633499435549499787L;

    private String seq;
    private String productName;
    private String productPrice;
    private String productImg;
    private String productLink;
    private String productOrd;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String uptDttm;

}
