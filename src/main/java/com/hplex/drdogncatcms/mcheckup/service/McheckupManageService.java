package com.hplex.drdogncatcms.mcheckup.service;

import java.util.List;

public interface McheckupManageService {

    // select list
    public List<?> selectMcheckupList(McheckupDefaultVO mcheckupSearchVO) throws Exception;

    // select one
    public McheckupManageVO selectMcheckup(String seq) throws Exception;

    // update one
    public void updateMcheckup(McheckupManageVO mcheckupManageVO) throws Exception;



    // select list
    public List<?> selectCheckupList(CheckupDefaultVO checkupSearchVO) throws Exception;

    // select one
    public CheckupManageVO selectCheckup(String seq) throws Exception;


}
