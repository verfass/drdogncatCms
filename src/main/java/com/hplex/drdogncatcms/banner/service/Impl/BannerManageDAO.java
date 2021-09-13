package com.hplex.drdogncatcms.banner.service.Impl;

import com.hplex.drdogncatcms.banner.service.BannerDefaultVO;
import com.hplex.drdogncatcms.banner.service.BannerManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BannerManageDAO {

    // select list
    public List<?> selectBannerList(BannerDefaultVO bannerSearchVO);

    // select one
    public BannerManageVO selectBanner(String seq);

    // insert one
    public String insertBanner(BannerManageVO bannerManageVO);

    // update one
    public void updateBanner(BannerManageVO bannerManageVO);

    // delete one
    public void deleteBanner(String itemId);

}
