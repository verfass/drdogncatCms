package com.hplex.drdogncatcms.mypets.service.Impl;

import com.hplex.drdogncatcms.member.service.MemberManageVO;
import com.hplex.drdogncatcms.mypets.service.MypetsDefaultVO;
import com.hplex.drdogncatcms.mypets.service.MypetsManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MypetsManageDAO {

    public List<?> selectMypetsList(MypetsDefaultVO mypetsSearchVO);

    public MypetsManageVO selectMypets(String seq);

    public void updateMypets(MypetsManageVO mypetsManageVO);

    public void insertMypets(MypetsManageVO mypetsManageVO);

}
