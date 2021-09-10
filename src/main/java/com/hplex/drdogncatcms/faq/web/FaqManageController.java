package com.hplex.drdogncatcms.faq.web;

import com.hplex.drdogncatcms.faq.service.FaqDefaultVO;
import com.hplex.drdogncatcms.faq.service.FaqManageService;
import com.hplex.drdogncatcms.faq.service.FaqManageVO;
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
public class FaqManageController {

    private FaqManageService faqManageService;

    @RequestMapping("/faq/FaqList")
    public String faqList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("faqSearchVO") FaqDefaultVO faqSearchVO,
            @ModelAttribute("faqManageVO") FaqManageVO faqManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        faqSearchVO.setStrSubQuery(strSubQuery);
        faqSearchVO.setOrderByQuery(orderByQuery);
        faqSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = faqManageService.selectFaqList(faqSearchVO);

        model.addAttribute("resultList", resultList);

        return "/faq/FaqListView";

    }

    @RequestMapping("/faq/FaqInsertView")
    public String faqInsertView(
            @ModelAttribute("faqSearchVO") FaqDefaultVO faqSearchVO,
            @ModelAttribute("faqManageVO") FaqManageVO faqManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        return "/faq/FaqInsertView";

    }

    @RequestMapping("/faq/FaqInsert")
    public String faqInsert(
            @ModelAttribute("faqManageVO") FaqManageVO faqManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        faqManageService.insertFaq(faqManageVO);

        model.addAttribute("resultMsg", "입력 되었습니다.");

        return "forward:/faq/FaqList";
    }


    @RequestMapping("/faq/FaqSelectUpdtView")
    public String faqSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        FaqManageVO faqManageVO = faqManageService.selectFaq(selectedCd);

        log.info("faqManageVO : " + faqManageVO.toString());

        model.addAttribute("faqManageVO", faqManageVO);

        return "/faq/FaqSelectUpdtView";

    }

    @RequestMapping("/faq/FaqSelectUpdt")
    public String faqSelectUpdt(
            @ModelAttribute("faqManageVO") FaqManageVO faqManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        faqManageService.updateFaq(faqManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/faq/FaqList";

    }
}
