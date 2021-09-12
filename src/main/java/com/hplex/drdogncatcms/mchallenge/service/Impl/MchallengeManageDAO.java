package com.hplex.drdogncatcms.mchallenge.service.Impl;

import com.hplex.drdogncatcms.mchallenge.service.MchallengeDefaultVO;
import com.hplex.drdogncatcms.mchallenge.service.MchallengeManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MchallengeManageDAO {

    // select list
    public List<?> selectMchallengeList(MchallengeDefaultVO mchallengeSearchVO);

    // select one
    public MchallengeManageVO selectMchallenge(String seq);

    // insert one
    public int insertMchallenge(MchallengeManageVO mchallengeManageVO);

    // update one
    public void updateMchallenge(MchallengeManageVO mchallengeManageVO);

    // delete one
    public void deleteMchallenge(String itemId);

}
