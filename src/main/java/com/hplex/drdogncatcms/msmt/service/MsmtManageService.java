package com.hplex.drdogncatcms.msmt.service;

import java.util.List;

public interface MsmtManageService {

    // select list
    public List<?> selectMsmtList(MsmtDefaultVO msmtSearchVO) throws Exception;

    // select one
    public MsmtManageVO selectMsmt(String id) throws Exception;

    // update one
    public void updateMsmt(MsmtManageVO msmtManageVO) throws Exception;

}
