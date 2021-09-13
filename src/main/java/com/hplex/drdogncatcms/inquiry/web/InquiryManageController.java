package com.hplex.drdogncatcms.inquiry.web;

import com.hplex.drdogncatcms.inquiry.service.*;
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
public class InquiryManageController {

    private InquiryManageService inquiryManageService;

    @RequestMapping("/inquiry/InquiryList")
    public String inquiryList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("inquirySearchVO") InquiryDefaultVO inquirySearchVO,
            @ModelAttribute("inquiryManageVO") InquiryManageVO inquiryManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        inquirySearchVO.setStrSubQuery(strSubQuery);
        inquirySearchVO.setOrderByQuery(orderByQuery);
        inquirySearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = inquiryManageService.selectInquiryList(inquirySearchVO);

        model.addAttribute("resultList", resultList);

        InquiryTypeDefaultVO inquiryTypeSearchVO = new InquiryTypeDefaultVO();
        inquiryTypeSearchVO.setOrderByQuery(" seq ASC ");
        List<?> typeList = inquiryManageService.selectInquiryTypeList(inquiryTypeSearchVO);

        model.addAttribute("typeList", typeList);

        return "/inquiry/InquiryListView";

    }

    @RequestMapping("/inquiry/InquiryInsertView")
    public String inquiryInsertView(
            @ModelAttribute("inquirySearchVO") InquiryDefaultVO inquirySearchVO,
            @ModelAttribute("inquiryManageVO") InquiryManageVO inquiryManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        return "/inquiry/InquiryInsertView";

    }

    @RequestMapping("/inquiry/InquiryInsert")
    public String inquiryInsert(
            @ModelAttribute("inquiryManageVO") InquiryManageVO inquiryManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        inquiryManageService.insertInquiry(inquiryManageVO);

        model.addAttribute("resultMsg", "입력 되었습니다.");

        return "forward:/inquiry/InquiryList";
    }


    @RequestMapping("/inquiry/InquirySelectUpdtView")
    public String inquirySelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        InquiryManageVO inquiryManageVO = inquiryManageService.selectInquiry(selectedCd);

        log.info("inquiryManageVO : " + inquiryManageVO.toString());

        model.addAttribute("inquiryManageVO", inquiryManageVO);

        InquiryTypeDefaultVO inquiryTypeSearchVO = new InquiryTypeDefaultVO();
        inquiryTypeSearchVO.setOrderByQuery(" seq ASC ");
        List<?> typeList = inquiryManageService.selectInquiryTypeList(inquiryTypeSearchVO);

        model.addAttribute("typeList", typeList);

        return "/inquiry/InquirySelectUpdtView";

    }

    @RequestMapping("/inquiry/InquirySelectUpdt")
    public String inquirySelectUpdt(
            @ModelAttribute("inquiryManageVO") InquiryManageVO inquiryManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        inquiryManageVO.setAnswerAt("0");
        if (!inquiryManageVO.getAnswerContent().equals("")) inquiryManageVO.setAnswerAt("1");
        inquiryManageService.updateInquiry(inquiryManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/inquiry/InquiryList";

    }
}
