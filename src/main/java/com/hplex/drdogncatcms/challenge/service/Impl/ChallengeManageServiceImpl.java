package com.hplex.drdogncatcms.challenge.service.Impl;

import com.hplex.drdogncatcms.challenge.service.Impl.ChallengeManageDAO;
import com.hplex.drdogncatcms.challenge.service.ChallengeDefaultVO;
import com.hplex.drdogncatcms.challenge.service.ChallengeManageService;
import com.hplex.drdogncatcms.challenge.service.ChallengeManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("challengeManageService")
@Log4j2
@AllArgsConstructor
public class ChallengeManageServiceImpl implements ChallengeManageService {

    @Autowired
    private ChallengeManageDAO challengeManageDAO;

    // select list
    @Override
    public List<?> selectChallengeList(ChallengeDefaultVO challengeSearchVO) throws Exception {
        return challengeManageDAO.selectChallengeList(challengeSearchVO);
    }

    // select one
    @Override
    public ChallengeManageVO selectChallenge(String seq) throws Exception {
        return challengeManageDAO.selectChallenge(seq);
    }

    // insert one
    @Override
    public int insertChallenge(ChallengeManageVO challengeManageVO) throws Exception {
        return challengeManageDAO.insertChallenge(challengeManageVO);
    }

    // update one
    @Override
    public void updateChallenge(ChallengeManageVO challengeManageVO) throws Exception {
        challengeManageDAO.updateChallenge(challengeManageVO);
    }

    // delete one
    @Override
    public void deleteChallenge(String itemId) throws Exception {
        challengeManageDAO.deleteChallenge(itemId);
    }

}
