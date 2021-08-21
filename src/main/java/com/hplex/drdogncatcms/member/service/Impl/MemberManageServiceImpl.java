package com.hplex.drdogncatcms.member.service.Impl;

import com.hplex.drdogncatcms.member.service.MemberDefaultVO;
import com.hplex.drdogncatcms.member.service.MemberManageService;
import com.hplex.drdogncatcms.member.service.MemberManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberManageService")
@Log4j2
@AllArgsConstructor
public class MemberManageServiceImpl implements MemberManageService {

    @Autowired
    private MemberManageDAO memberManageDAO;

    @Override
    public List<?> selectMemberList(MemberDefaultVO memberSearchVO) throws Exception {
        return memberManageDAO.selectMemberList(memberSearchVO);
    }

    @Override
    public MemberManageVO selectMember(String seq) throws Exception {
        return memberManageDAO.selectMember(seq);
    }

    @Override
    public void updateMember(MemberManageVO memberManageVO) throws Exception {
        memberManageDAO.updateMember(memberManageVO);
    }

    @Override
    public void insertMember(MemberManageVO memberManageVO) throws Exception {
        memberManageDAO.insertMember(memberManageVO);
    }

}
