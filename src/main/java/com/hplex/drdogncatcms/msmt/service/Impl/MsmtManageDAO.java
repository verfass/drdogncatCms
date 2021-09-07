package com.hplex.drdogncatcms.msmt.service.Impl;

import com.hplex.drdogncatcms.msmt.service.MsmtDefaultVO;
import com.hplex.drdogncatcms.msmt.service.MsmtManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MsmtManageDAO {

    // select list
    public List<?> selectMsmtList(MsmtDefaultVO msmtSearchVO);

    // select one
    public MsmtManageVO selectMsmt(String seq);

    // update one
    public void updateMsmt(MsmtManageVO msmtManageVO);

}
