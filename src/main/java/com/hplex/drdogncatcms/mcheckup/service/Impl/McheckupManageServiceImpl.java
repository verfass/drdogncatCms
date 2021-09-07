package com.hplex.drdogncatcms.mcheckup.service.Impl;

import com.hplex.drdogncatcms.mcheckup.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mcheckupManageService")
@Log4j2
@AllArgsConstructor
public class McheckupManageServiceImpl implements McheckupManageService {

    @Autowired
    private McheckupManageDAO mcheckupManageDAO;

    @Autowired
    private CheckupManageDAO checkupManageDAO;

    // select list
    @Override
    public List<?> selectMcheckupList(McheckupDefaultVO mcheckupSearchVO) throws Exception {
        return mcheckupManageDAO.selectMcheckupList(mcheckupSearchVO);
    }

    // select one
    @Override
    public McheckupManageVO selectMcheckup(String seq) throws Exception {
        return mcheckupManageDAO.selectMcheckup(seq);
    }

    // update one
    @Override
    public void updateMcheckup(McheckupManageVO mcheckupManageVO) throws Exception {
        mcheckupManageDAO.updateMcheckup(mcheckupManageVO);
    }



    // select list
    @Override
    public List<?> selectCheckupList(CheckupDefaultVO checkupSearchVO) throws Exception {
        return checkupManageDAO.selectCheckupList(checkupSearchVO);
    }

    // select one
    @Override
    public CheckupManageVO selectCheckup(String seq) throws Exception {
        return checkupManageDAO.selectCheckup(seq);
    }
}
