package com.hplex.drdogncatcms.challenge.service.Impl;

import com.hplex.drdogncatcms.challenge.service.ChallengeDefaultVO;
import com.hplex.drdogncatcms.challenge.service.ChallengeManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ChallengeManageDAO {

    // select list
    public List<?> selectChallengeList(ChallengeDefaultVO challengeSearchVO);

    // select one
    public ChallengeManageVO selectChallenge(String seq);

    // insert one
    public int insertChallenge(ChallengeManageVO challengeManageVO);

    // update one
    public void updateChallenge(ChallengeManageVO challengeManageVO);

    // delete one
    public void deleteChallenge(String itemId);

}
