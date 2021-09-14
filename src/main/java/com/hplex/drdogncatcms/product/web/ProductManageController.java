package com.hplex.drdogncatcms.product.web;

import com.hplex.drdogncatcms.common.file.service.FileManageService;
import com.hplex.drdogncatcms.common.file.service.FileManageVO;
import com.hplex.drdogncatcms.product.service.ProductDefaultVO;
import com.hplex.drdogncatcms.product.service.ProductManageService;
import com.hplex.drdogncatcms.product.service.ProductManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Log4j2
public class ProductManageController {

    @Autowired
    private ProductManageService productManageService;

    @Autowired
    private FileManageService fileService;

    @Value("${file.url}")
    private String fileUrl;

    private String type = "product";

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
        model.addAttribute("fileUrl", fileUrl);
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
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("productManageVO") ProductManageVO productManageVO,
            @RequestParam(value="file", required=false) MultipartFile file,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        log.debug("file : " + file);
        log.debug("file : " + file.toString());

        String resultMsg = "";
        String saveFileName = "";

        String sSeq = productManageService.insertProduct(productManageVO);

        if (!file.isEmpty()) {

//            if (fileService.isPermisionFileMimeType(file)) {
                // 파일 저장
                FileManageVO fileManageVO = new FileManageVO();
                fileManageVO.setFiledata(file);
                fileManageVO.setSSeq(sSeq);
                fileManageVO.setType(type);
                saveFileName = fileService.saveFile(fileManageVO);

                productManageVO = productManageService.selectProduct(sSeq);
                productManageVO.setProductImg(saveFileName);
                productManageService.updateProduct(productManageVO);
//            }
        }

        resultMsg = "입력 되었습니다.";
        model.addAttribute("resultMsg", resultMsg);

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
        model.addAttribute("fileUrl", fileUrl);

        return "/product/ProductSelectUpdtView";

    }

    @RequestMapping("/product/ProductSelectUpdt")
    public String productSelectUpdt(
            @ModelAttribute("productManageVO") ProductManageVO productManageVO,
            @RequestParam(value="file", required=false) MultipartFile file,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        log.debug("file : " + file);
        log.debug("file : " + file.toString());

        String resultMsg = "";
        String saveFileName = "";

        String sSeq = productManageVO.getSeq();

        if (!file.isEmpty()) {

//            if (fileService.isPermisionFileMimeType(file)) {
                // 파일 저장
                FileManageVO fileManageVO = new FileManageVO();
                fileManageVO.setFiledata(file);
                fileManageVO.setSSeq(sSeq);
                fileManageVO.setType(type);
                saveFileName = fileService.saveFile(fileManageVO);

                productManageVO.setProductImg(saveFileName);
//            }
        }

        // 저장
        productManageService.updateProduct(productManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/product/ProductList";

    }
}
