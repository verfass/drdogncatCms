package com.hplex.drdogncatcms.admin.service;

import com.hplex.drdogncatcms.role.service.RoleDefaultVO;
import com.hplex.drdogncatcms.role.service.RoleManageVO;

import java.util.List;

public interface AdminManageService {

    // select list
    public List<?> selectAdminList(AdminDefaultVO adminSearchVO) throws Exception;

    // select one
    public AdminManageVO selectAdmin(String seq) throws Exception;

    // update one
    public void updateAdmin(AdminManageVO adminManageVO) throws Exception;

    // insert one
    public void insertAdmin(AdminManageVO adminManageVO) throws Exception;

}
