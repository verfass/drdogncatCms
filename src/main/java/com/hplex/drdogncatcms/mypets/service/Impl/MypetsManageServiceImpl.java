package com.hplex.drdogncatcms.mypets.service.Impl;

import com.hplex.drdogncatcms.mypets.service.MypetsDefaultVO;
import com.hplex.drdogncatcms.mypets.service.MypetsManageService;
import com.hplex.drdogncatcms.mypets.service.MypetsManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mypetsManageService")
@Log4j2
@AllArgsConstructor
public class MypetsManageServiceImpl implements MypetsManageService {

    @Autowired
    private MypetsManageDAO mypetsManageDAO;

    @Override
    public List<?> selectMypetsList(MypetsDefaultVO mypetsSearchVO) throws Exception {
        return mypetsManageDAO.selectMypetsList(mypetsSearchVO);
    }

    @Override
    public MypetsManageVO selectMypets(String seq) throws Exception {
        return mypetsManageDAO.selectMypets(seq);
    }

    @Override
    public void updateMypets(MypetsManageVO mypetsManageVO) throws Exception {
        mypetsManageDAO.updateMypets(mypetsManageVO);
    }

    @Override
    public void insertMypets(MypetsManageVO mypetsManageVO) throws Exception {
        mypetsManageDAO.insertMypets(mypetsManageVO);
    }

}
