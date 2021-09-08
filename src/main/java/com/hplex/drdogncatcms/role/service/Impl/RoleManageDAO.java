package com.hplex.drdogncatcms.role.service.Impl;

import com.hplex.drdogncatcms.admin.service.AdminDefaultVO;
import com.hplex.drdogncatcms.admin.service.AdminManageVO;
import com.hplex.drdogncatcms.role.service.RoleDefaultVO;
import com.hplex.drdogncatcms.role.service.RoleManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleManageDAO {

    // select list
    public List<?> selectRoleList(RoleDefaultVO roleSearchVO);

    // select one
    public RoleManageVO selectRole(String seq);

    // update one
    public void updateRole(RoleManageVO roleManageVO);

    // insert one
    public void insertRole(RoleManageVO roleManageVO);

}
