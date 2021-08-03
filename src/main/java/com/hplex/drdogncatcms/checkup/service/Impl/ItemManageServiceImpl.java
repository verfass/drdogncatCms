package com.hplex.drdogncatcms.checkup.service.Impl;

import com.hplex.drdogncatcms.checkup.service.ItemDefaultVO;
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
    public List<?> selectItemList(ItemDefaultVO itemSearchVO) throws Exception{
        return itemManageDAO.selectItemList(itemSearchVO);
    }

    // select one
    @Override
    public ItemManageVO selectItem(String id) throws Exception {
        return itemManageDAO.selectItem(id);
    }

    // update one
    @Override
    public void updateItem(ItemManageVO itemManageVO) throws Exception {
        itemManageDAO.updateItem(itemManageVO);
    }
}
