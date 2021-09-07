package com.hplex.drdogncatcms.mcheckup.service.Impl;

import com.hplex.drdogncatcms.mcheckup.service.McheckupDefaultVO;
import com.hplex.drdogncatcms.mcheckup.service.McheckupManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface McheckupManageDAO {

    // select list
    public List<?> selectMcheckupList(McheckupDefaultVO mcheckupSearchVO);

    // select one
    public McheckupManageVO selectMcheckup(String seq);

    // update one
    public void updateMcheckup(McheckupManageVO mcheckupManageVO);

}
