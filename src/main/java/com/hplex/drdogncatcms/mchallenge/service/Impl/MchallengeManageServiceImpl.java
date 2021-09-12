package com.hplex.drdogncatcms.mchallenge.service.Impl;

import com.hplex.drdogncatcms.mchallenge.service.Impl.MchallengeManageDAO;
import com.hplex.drdogncatcms.mchallenge.service.MchallengeDefaultVO;
import com.hplex.drdogncatcms.mchallenge.service.MchallengeManageService;
import com.hplex.drdogncatcms.mchallenge.service.MchallengeManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mchallengeManageService")
@Log4j2
@AllArgsConstructor
public class MchallengeManageServiceImpl implements MchallengeManageService {

    @Autowired
    private MchallengeManageDAO mchallengeManageDAO;

    // select list
    @Override
    public List<?> selectMchallengeList(MchallengeDefaultVO mchallengeSearchVO) throws Exception {
        return mchallengeManageDAO.selectMchallengeList(mchallengeSearchVO);
    }

    // select one
    @Override
    public MchallengeManageVO selectMchallenge(String seq) throws Exception {
        return mchallengeManageDAO.selectMchallenge(seq);
    }

    // insert one
    @Override
    public int insertMchallenge(MchallengeManageVO mchallengeManageVO) throws Exception {
        return mchallengeManageDAO.insertMchallenge(mchallengeManageVO);
    }

    // update one
    @Override
    public void updateMchallenge(MchallengeManageVO mchallengeManageVO) throws Exception {
        mchallengeManageDAO.updateMchallenge(mchallengeManageVO);
    }

    // delete one
    @Override
    public void deleteMchallenge(String itemId) throws Exception {
        mchallengeManageDAO.deleteMchallenge(itemId);
    }

}
