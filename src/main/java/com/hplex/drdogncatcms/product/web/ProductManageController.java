package com.hplex.drdogncatcms.product.web;

import com.hplex.drdogncatcms.product.service.ProductDefaultVO;
import com.hplex.drdogncatcms.product.service.ProductManageService;
import com.hplex.drdogncatcms.product.service.ProductManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Log4j2
@AllArgsConstructor
public class ProductManageController {

    private ProductManageService productManageService;

    @RequestMapping("/product/ProductList")
    public String productList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("productSearchVO") ProductDefaultVO productSearchVO,
            @ModelAttribute("productManageVO") ProductManageVO productManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        productSearchVO.setStrSubQuery(strSubQuery);
        productSearchVO.setOrderByQuery(orderByQuery);
        productSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = productManageService.selectProductList(productSearchVO);

        model.addAttribute("resultList", resultList);

        return "/product/ProductListView";

    }

    @RequestMapping("/product/ProductInsertView")
    public String productInsertView(
            @ModelAttribute("productSearchVO") ProductDefaultVO productSearchVO,
            @ModelAttribute("productManageVO") ProductManageVO productManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        return "/product/ProductInsertView";

    }

    @RequestMapping("/product/ProductInsert")
    public String productInsert(
            @ModelAttribute("productManageVO") ProductManageVO productManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        productManageService.insertProduct(productManageVO);

        model.addAttribute("resultMsg", "입력 되었습니다.");

        return "forward:/product/ProductList";
    }


    @RequestMapping("/product/ProductSelectUpdtView")
    public String productSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        ProductManageVO productManageVO = productManageService.selectProduct(selectedCd);

        log.info("productManageVO : " + productManageVO.toString());

        model.addAttribute("productManageVO", productManageVO);

        return "/product/ProductSelectUpdtView";

    }

    @RequestMapping("/product/ProductSelectUpdt")
    public String productSelectUpdt(
            @ModelAttribute("productManageVO") ProductManageVO productManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        productManageService.updateProduct(productManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/product/ProductList";

    }
}
