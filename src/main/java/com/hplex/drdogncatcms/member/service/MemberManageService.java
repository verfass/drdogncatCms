package com.hplex.drdogncatcms.member.service;

import com.hplex.drdogncatcms.disease.service.DiseaseDefaultVO;
import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;

import java.util.List;

public interface MemberManageService {

    // select list
    public List<?> selectMemberList(MemberDefaultVO memberSearchVO) throws Exception;

    // select one
    public MemberManageVO selectMember(String seq) throws Exception;

    // update one
    public void updateMember(MemberManageVO memberManageVO) throws Exception;

    // insert one
    public void insertMember(MemberManageVO memberManageVO) throws Exception;
}
