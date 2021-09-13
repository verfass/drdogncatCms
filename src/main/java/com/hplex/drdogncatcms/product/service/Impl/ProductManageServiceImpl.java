package com.hplex.drdogncatcms.product.service.Impl;

import com.hplex.drdogncatcms.product.service.Impl.ProductManageDAO;
import com.hplex.drdogncatcms.product.service.ProductDefaultVO;
import com.hplex.drdogncatcms.product.service.ProductManageService;
import com.hplex.drdogncatcms.product.service.ProductManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productManageService")
@Log4j2
@AllArgsConstructor
public class ProductManageServiceImpl implements ProductManageService {

    @Autowired
    private ProductManageDAO productManageDAO;

    // select list
    @Override
    public List<?> selectProductList(ProductDefaultVO productSearchVO) throws Exception {
        return productManageDAO.selectProductList(productSearchVO);
    }

    // select one
    @Override
    public ProductManageVO selectProduct(String seq) throws Exception {
        return productManageDAO.selectProduct(seq);
    }

    // insert one
    @Override
    public String insertProduct(ProductManageVO productManageVO) throws Exception {
        return productManageDAO.insertProduct(productManageVO);
    }

    // update one
    @Override
    public void updateProduct(ProductManageVO productManageVO) throws Exception {
        productManageDAO.updateProduct(productManageVO);
    }

    // delete one
    @Override
    public void deleteProduct(String itemId) throws Exception {
        productManageDAO.deleteProduct(itemId);
    }

}
