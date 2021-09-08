package com.hplex.drdogncatcms.role.service.Impl;

import com.hplex.drdogncatcms.role.service.RoleDefaultVO;
import com.hplex.drdogncatcms.role.service.RoleManageService;
import com.hplex.drdogncatcms.role.service.RoleManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleManageService")
@Log4j2
@AllArgsConstructor
public class RoleManageServiceImpl implements RoleManageService {

    @Autowired
    private RoleManageDAO roleManageDAO;

    // select list
    @Override
    public List<?> selectRoleList(RoleDefaultVO roleSearchVO) throws Exception {
        return roleManageDAO.selectRoleList(roleSearchVO);
    }

    // select one
    @Override
    public RoleManageVO selectRole(String seq) throws Exception {
        return roleManageDAO.selectRole(seq);
    }

    // update one
    @Override
    public void updateRole(RoleManageVO roleManageVO) throws Exception {
        roleManageDAO.updateRole(roleManageVO);
    }

    // insert one
    @Override
    public void insertRole(RoleManageVO roleManageVO) throws Exception {
        roleManageDAO.insertRole(roleManageVO);
    }

}
