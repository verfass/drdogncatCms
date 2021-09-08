package com.hplex.drdogncatcms.admin.service.Impl;

import com.hplex.drdogncatcms.admin.service.AdminDefaultVO;
import com.hplex.drdogncatcms.admin.service.AdminManageVO;
import com.hplex.drdogncatcms.role.service.RoleDefaultVO;
import com.hplex.drdogncatcms.role.service.RoleManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminManageDAO {

    // select list
    public List<?> selectAdminList(AdminDefaultVO adminSearchVO);

    // select one
    public AdminManageVO selectAdmin(String seq);

    // update one
    public void updateAdmin(AdminManageVO adminManageVO);

    // insert one
    public void insertAdmin(AdminManageVO adminManageVO);

}
