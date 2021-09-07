package com.hplex.drdogncatcms.msmt.service.Impl;

import com.hplex.drdogncatcms.msmt.service.MsmtDefaultVO;
import com.hplex.drdogncatcms.msmt.service.MsmtManageService;
import com.hplex.drdogncatcms.msmt.service.MsmtManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("msmtManageService")
@Log4j2
@AllArgsConstructor
public class MsmtManageServiceImpl implements MsmtManageService {

    @Autowired
    private MsmtManageDAO msmtManageDAO;

    // select list
    @Override
    public List<?> selectMsmtList(MsmtDefaultVO msmtSearchVO) throws Exception {
        return msmtManageDAO.selectMsmtList(msmtSearchVO);
    }

    // select one
    @Override
    public MsmtManageVO selectMsmt(String seq) throws Exception {
        return msmtManageDAO.selectMsmt(seq);
    }

    // update one
    @Override
    public void updateMsmt(MsmtManageVO msmtManageVO) throws Exception {
        msmtManageDAO.updateMsmt(msmtManageVO);
    }
}
