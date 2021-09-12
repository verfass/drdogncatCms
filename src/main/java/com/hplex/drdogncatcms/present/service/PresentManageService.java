package com.hplex.drdogncatcms.present.service;

import com.hplex.drdogncatcms.present.service.PresentDefaultVO;
import com.hplex.drdogncatcms.present.service.PresentManageVO;

import java.util.List;

public interface PresentManageService {

    // select list
    public List<?> selectPresentList(PresentDefaultVO presentSearchVO) throws Exception;

    // select one
    public PresentManageVO selectPresent(String seq) throws Exception;

    // insert one
    public int insertPresent(PresentManageVO presentManageVO) throws Exception;

    // update one
    public void updatePresent(PresentManageVO presentManageVO) throws Exception;

    // delete one
    public void deletePresent(String itemId) throws Exception;

}
