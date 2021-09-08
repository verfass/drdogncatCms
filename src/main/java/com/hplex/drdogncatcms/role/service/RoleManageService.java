package com.hplex.drdogncatcms.role.service;

import com.hplex.drdogncatcms.admin.service.AdminDefaultVO;
import com.hplex.drdogncatcms.admin.service.AdminManageVO;

import java.util.List;

public interface RoleManageService {

    // select list
    public List<?> selectRoleList(RoleDefaultVO roleSearchVO) throws Exception;

    // select one
    public RoleManageVO selectRole(String seq) throws Exception;

    // update one
    public void updateRole(RoleManageVO roleManageVO) throws Exception;

    // insert one
    public void insertRole(RoleManageVO roleManageVO) throws Exception;

}
