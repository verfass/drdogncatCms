package com.hplex.drdogncatcms.checkup.service.Impl;

import com.hplex.drdogncatcms.checkup.service.ItemManageService;
import com.hplex.drdogncatcms.checkup.service.ItemManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemManageService")
@Log4j2
@AllArgsConstructor
public class ItemManageServiceImpl implements ItemManageService {

    @Autowired
    private ItemManageDAO itemManageDAO;

    // select list
    @Override
    public List<ItemManageVO> selectItemList(String parentId) throws Exception{
        return itemManageDAO.selectItemList(parentId);
    }

    // select one
    @Override
    public ItemManageVO selectItem(String id) throws Exception {
        return itemManageDAO.selectItem(id);
    }

    // update one
}
