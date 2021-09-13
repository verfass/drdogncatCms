package com.hplex.drdogncatcms.product.service.Impl;

import com.hplex.drdogncatcms.product.service.ProductDefaultVO;
import com.hplex.drdogncatcms.product.service.ProductManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductManageDAO {

    // select list
    public List<?> selectProductList(ProductDefaultVO productSearchVO);

    // select one
    public ProductManageVO selectProduct(String seq);

    // insert one
    public String insertProduct(ProductManageVO productManageVO);

    // update one
    public void updateProduct(ProductManageVO productManageVO);

    // delete one
    public void deleteProduct(String itemId);

}
