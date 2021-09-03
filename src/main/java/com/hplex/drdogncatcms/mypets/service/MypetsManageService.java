package com.hplex.drdogncatcms.mypets.service;

import java.util.List;

public interface MypetsManageService {

    // select list
    public List<?> selectMypetsList(MypetsDefaultVO mypetsSearchVO) throws Exception;

    // select one
    public MypetsManageVO selectMypets(String seq) throws Exception;

    // update one
    public void updateMypets(MypetsManageVO mypetsManageVO) throws Exception;

    // insert one
    public void insertMypets(MypetsManageVO mypetsManageVO) throws Exception;
}
