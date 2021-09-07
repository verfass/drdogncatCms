package com.hplex.drdogncatcms.mcheckup.service.Impl;

import com.hplex.drdogncatcms.mcheckup.service.CheckupDefaultVO;
import com.hplex.drdogncatcms.mcheckup.service.CheckupManageVO;
import com.hplex.drdogncatcms.mcheckup.service.McheckupDefaultVO;
import com.hplex.drdogncatcms.mcheckup.service.McheckupManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CheckupManageDAO {

    // select list
    public List<?> selectCheckupList(CheckupDefaultVO checkupSearchVO);

    // select one
    public CheckupManageVO selectCheckup(String seq);

}
