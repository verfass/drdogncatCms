package com.hplex.drdogncatcms.member.service.Impl;

import com.hplex.drdogncatcms.disease.service.DiseaseDefaultVO;
import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;
import com.hplex.drdogncatcms.member.service.MemberDefaultVO;
import com.hplex.drdogncatcms.member.service.MemberManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberManageDAO {

    public List<?> selectMemberList(MemberDefaultVO memberSearchVO);

    public MemberManageVO selectMember(String seq);

    public void updateMember(MemberManageVO memberManageVO);

    public void insertMember(MemberManageVO memberManageVO);

}
