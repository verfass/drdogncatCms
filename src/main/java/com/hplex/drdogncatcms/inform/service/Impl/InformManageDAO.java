package com.hplex.drdogncatcms.inform.service.Impl;

import com.hplex.drdogncatcms.inform.service.InformDefaultVO;
import com.hplex.drdogncatcms.inform.service.InformManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InformManageDAO {

    // select list
    public List<?> selectInformList(InformDefaultVO informSearchVO);

    // select one
    public InformManageVO selectInform(String seq);

    // insert one
    public int insertInform(InformManageVO informManageVO);

    // update one
    public void updateInform(InformManageVO informManageVO);

    // delete one
    public void deleteInform(String itemId);

}
