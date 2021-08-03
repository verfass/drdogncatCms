package com.hplex.drdogncatcms.checkup.service.Impl;

import com.hplex.drdogncatcms.checkup.service.ItemDefaultVO;
import com.hplex.drdogncatcms.checkup.service.ItemManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemManageDAO {

    // select list
    public List<?> selectItemList(ItemDefaultVO itemSearchVO);

    // select one
    public ItemManageVO selectItem(String id);

    // update one
    public void updateItem(ItemManageVO itemManageVO);

}
