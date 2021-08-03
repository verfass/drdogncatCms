package com.hplex.drdogncatcms.checkup.service;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ItemManageVO extends ItemDefaultVO {

    private static final long serialVersionUID = -2584523821182557999L;

    private String id;
    private String parentId;
    private String categoryId;
    private String itemName;
    private String itemEngName;
    private String itemDescription;
    private String itemCause;
    private String diseaseIds;
    private String diseaseNames;
    private String diseases;
    private String productIds;
    private String refRed;
    private String refGreen;
    private String refBlue;
    private String ord;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String uptDttm;

}
