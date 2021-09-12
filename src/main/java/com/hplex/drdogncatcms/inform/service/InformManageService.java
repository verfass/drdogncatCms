package com.hplex.drdogncatcms.inform.service;

import com.hplex.drdogncatcms.inform.service.InformDefaultVO;
import com.hplex.drdogncatcms.inform.service.InformManageVO;

import java.util.List;

public interface InformManageService {

    // select list
    public List<?> selectInformList(InformDefaultVO informSearchVO) throws Exception;

    // select one
    public InformManageVO selectInform(String seq) throws Exception;

    // insert one
    public int insertInform(InformManageVO informManageVO) throws Exception;

    // update one
    public void updateInform(InformManageVO informManageVO) throws Exception;

    // delete one
    public void deleteInform(String itemId) throws Exception;

}
