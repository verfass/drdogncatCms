package com.hplex.drdogncatcms.checkup.service;

import java.util.List;

public interface ItemManageService {

    // select list
    public List<ItemManageVO> selectItemList(String parentId) throws Exception;

    // select one
    public ItemManageVO selectItem(String id) throws Exception;

    // update one
    public void updateItem(ItemManageVO itemManageVO) throws Exception;


}
