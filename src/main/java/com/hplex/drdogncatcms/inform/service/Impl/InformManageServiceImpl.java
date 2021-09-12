package com.hplex.drdogncatcms.inform.service.Impl;

import com.hplex.drdogncatcms.inform.service.Impl.InformManageDAO;
import com.hplex.drdogncatcms.inform.service.InformDefaultVO;
import com.hplex.drdogncatcms.inform.service.InformManageService;
import com.hplex.drdogncatcms.inform.service.InformManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("informManageService")
@Log4j2
@AllArgsConstructor
public class InformManageServiceImpl implements InformManageService {

    @Autowired
    private InformManageDAO informManageDAO;

    // select list
    @Override
    public List<?> selectInformList(InformDefaultVO informSearchVO) throws Exception {
        return informManageDAO.selectInformList(informSearchVO);
    }

    // select one
    @Override
    public InformManageVO selectInform(String seq) throws Exception {
        return informManageDAO.selectInform(seq);
    }

    // insert one
    @Override
    public int insertInform(InformManageVO informManageVO) throws Exception {
        return informManageDAO.insertInform(informManageVO);
    }

    // update one
    @Override
    public void updateInform(InformManageVO informManageVO) throws Exception {
        informManageDAO.updateInform(informManageVO);
    }

    // delete one
    @Override
    public void deleteInform(String itemId) throws Exception {
        informManageDAO.deleteInform(itemId);
    }

}
