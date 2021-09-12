package com.hplex.drdogncatcms.present.service.Impl;

import com.hplex.drdogncatcms.present.service.Impl.PresentManageDAO;
import com.hplex.drdogncatcms.present.service.PresentDefaultVO;
import com.hplex.drdogncatcms.present.service.PresentManageService;
import com.hplex.drdogncatcms.present.service.PresentManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("presentManageService")
@Log4j2
@AllArgsConstructor
public class PresentManageServiceImpl implements PresentManageService {

    @Autowired
    private PresentManageDAO presentManageDAO;

    // select list
    @Override
    public List<?> selectPresentList(PresentDefaultVO presentSearchVO) throws Exception {
        return presentManageDAO.selectPresentList(presentSearchVO);
    }

    // select one
    @Override
    public PresentManageVO selectPresent(String seq) throws Exception {
        return presentManageDAO.selectPresent(seq);
    }

    // insert one
    @Override
    public int insertPresent(PresentManageVO presentManageVO) throws Exception {
        return presentManageDAO.insertPresent(presentManageVO);
    }

    // update one
    @Override
    public void updatePresent(PresentManageVO presentManageVO) throws Exception {
        presentManageDAO.updatePresent(presentManageVO);
    }

    // delete one
    @Override
    public void deletePresent(String itemId) throws Exception {
        presentManageDAO.deletePresent(itemId);
    }

}
