package com.hplex.drdogncatcms.admin.service.Impl;

import com.hplex.drdogncatcms.admin.service.*;
import com.hplex.drdogncatcms.role.service.RoleDefaultVO;
import com.hplex.drdogncatcms.role.service.RoleManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminManageService")
@Log4j2
@AllArgsConstructor
public class AdminManageServiceImpl implements AdminManageService {

    @Autowired
    private AdminManageDAO adminManageDAO;

    // select list
    @Override
    public List<?> selectAdminList(AdminDefaultVO adminSearchVO) throws Exception {
        return adminManageDAO.selectAdminList(adminSearchVO);
    }

    // select one
    @Override
    public AdminManageVO selectAdmin(String seq) throws Exception {
        return adminManageDAO.selectAdmin(seq);
    }

    // update one
    @Override
    public void updateAdmin(AdminManageVO adminManageVO) throws Exception {
        adminManageDAO.updateAdmin(adminManageVO);
    }

    // insert one
    @Override
    public void insertAdmin(AdminManageVO adminManageVO) throws Exception {
        adminManageDAO.insertAdmin(adminManageVO);
    }

}
