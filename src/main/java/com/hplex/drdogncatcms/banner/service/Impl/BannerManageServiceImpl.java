package com.hplex.drdogncatcms.banner.service.Impl;

import com.hplex.drdogncatcms.banner.service.Impl.BannerManageDAO;
import com.hplex.drdogncatcms.banner.service.BannerDefaultVO;
import com.hplex.drdogncatcms.banner.service.BannerManageService;
import com.hplex.drdogncatcms.banner.service.BannerManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bannerManageService")
@Log4j2
@AllArgsConstructor
public class BannerManageServiceImpl implements BannerManageService {

    @Autowired
    private BannerManageDAO bannerManageDAO;

    // select list
    @Override
    public List<?> selectBannerList(BannerDefaultVO bannerSearchVO) throws Exception {
        return bannerManageDAO.selectBannerList(bannerSearchVO);
    }

    // select one
    @Override
    public BannerManageVO selectBanner(String seq) throws Exception {
        return bannerManageDAO.selectBanner(seq);
    }

    // insert one
    @Override
    public String insertBanner(BannerManageVO bannerManageVO) throws Exception {
        return bannerManageDAO.insertBanner(bannerManageVO);
    }

    // update one
    @Override
    public void updateBanner(BannerManageVO bannerManageVO) throws Exception {
        bannerManageDAO.updateBanner(bannerManageVO);
    }

    // delete one
    @Override
    public void deleteBanner(String itemId) throws Exception {
        bannerManageDAO.deleteBanner(itemId);
    }

}
