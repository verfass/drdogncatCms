package com.hplex.drdogncatcms.banner.service;

import com.hplex.drdogncatcms.banner.service.BannerDefaultVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class BannerManageVO extends BannerDefaultVO {

    private static final long serialVersionUID = 8714517780317563623L;

    private String seq;
    private String bannerTitle;
    private String bannerImg;
    private String bannerLink;
    private String bannerOrd;
    private String chkAt;
    private String delAt;
    private String insDttm;
    private String uptDttm;
    private String insUser;
    private String uptUser;

}
