package com.hplex.drdogncatcms.mchallenge.service;

import com.hplex.drdogncatcms.mchallenge.service.MchallengeDefaultVO;
import com.hplex.drdogncatcms.mchallenge.service.MchallengeManageVO;

import java.util.List;

public interface MchallengeManageService {

    // select list
    public List<?> selectMchallengeList(MchallengeDefaultVO mchallengeSearchVO) throws Exception;

    // select one
    public MchallengeManageVO selectMchallenge(String seq) throws Exception;

    // insert one
    public int insertMchallenge(MchallengeManageVO mchallengeManageVO) throws Exception;

    // update one
    public void updateMchallenge(MchallengeManageVO mchallengeManageVO) throws Exception;

    // delete one
    public void deleteMchallenge(String itemId) throws Exception;

}
