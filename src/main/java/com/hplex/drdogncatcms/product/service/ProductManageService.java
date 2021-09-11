package com.hplex.drdogncatcms.product.service;

import com.hplex.drdogncatcms.product.service.ProductDefaultVO;
import com.hplex.drdogncatcms.product.service.ProductManageVO;

import java.util.List;

public interface ProductManageService {

    // select list
    public List<?> selectProductList(ProductDefaultVO productSearchVO) throws Exception;

    // select one
    public ProductManageVO selectProduct(String seq) throws Exception;

    // insert one
    public int insertProduct(ProductManageVO productManageVO) throws Exception;

    // update one
    public void updateProduct(ProductManageVO productManageVO) throws Exception;

    // delete one
    public void deleteProduct(String itemId) throws Exception;

}
