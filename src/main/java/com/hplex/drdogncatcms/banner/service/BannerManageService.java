package com.hplex.drdogncatcms.banner.service;

import com.hplex.drdogncatcms.banner.service.BannerDefaultVO;
import com.hplex.drdogncatcms.banner.service.BannerManageVO;

import java.util.List;

public interface BannerManageService {

    // select list
    public List<?> selectBannerList(BannerDefaultVO bannerSearchVO) throws Exception;

    // select one
    public BannerManageVO selectBanner(String seq) throws Exception;

    // insert one
    public int insertBanner(BannerManageVO bannerManageVO) throws Exception;

    // update one
    public void updateBanner(BannerManageVO bannerManageVO) throws Exception;

    // delete one
    public void deleteBanner(String itemId) throws Exception;

}
