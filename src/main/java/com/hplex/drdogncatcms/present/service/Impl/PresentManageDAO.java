package com.hplex.drdogncatcms.present.service.Impl;

import com.hplex.drdogncatcms.present.service.PresentDefaultVO;
import com.hplex.drdogncatcms.present.service.PresentManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PresentManageDAO {

    // select list
    public List<?> selectPresentList(PresentDefaultVO presentSearchVO);

    // select one
    public PresentManageVO selectPresent(String seq);

    // insert one
    public int insertPresent(PresentManageVO presentManageVO);

    // update one
    public void updatePresent(PresentManageVO presentManageVO);

    // delete one
    public void deletePresent(String itemId);

}
