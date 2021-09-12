package com.hplex.drdogncatcms.challenge.service;

import com.hplex.drdogncatcms.challenge.service.ChallengeDefaultVO;
import com.hplex.drdogncatcms.challenge.service.ChallengeManageVO;

import java.util.List;

public interface ChallengeManageService {

    // select list
    public List<?> selectChallengeList(ChallengeDefaultVO challengeSearchVO) throws Exception;

    // select one
    public ChallengeManageVO selectChallenge(String seq) throws Exception;

    // insert one
    public int insertChallenge(ChallengeManageVO challengeManageVO) throws Exception;

    // update one
    public void updateChallenge(ChallengeManageVO challengeManageVO) throws Exception;

    // delete one
    public void deleteChallenge(String itemId) throws Exception;

}
