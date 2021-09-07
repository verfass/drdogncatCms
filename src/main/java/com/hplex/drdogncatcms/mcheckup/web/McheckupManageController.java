package com.hplex.drdogncatcms.mcheckup.web;

import com.hplex.drdogncatcms.mcheckup.service.CheckupDefaultVO;
import com.hplex.drdogncatcms.mcheckup.service.CheckupManageVO;
import com.hplex.drdogncatcms.mcheckup.service.McheckupManageService;
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
public class McheckupManageController {

    private McheckupManageService mcheckupManageService;

    @RequestMapping("/mcheckup/McheckupList")
    public String mcheckupList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("checkupSearchVO") CheckupDefaultVO checkupSearchVO,
            @ModelAttribute("checkupManageVO") CheckupManageVO checkupManageVO,
            @RequestParam(value="categoryId", defaultValue="101") String categoryId,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        checkupSearchVO.setSearchCategoryId(categoryId);

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " checkup_seq DESC ";

        checkupSearchVO.setStrSubQuery(strSubQuery);
        checkupSearchVO.setOrderByQuery(orderByQuery);
        checkupSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = mcheckupManageService.selectCheckupList(checkupSearchVO);

        model.addAttribute("resultList", resultList);
        model.addAttribute("categoryId", categoryId);

        return "/mcheckup/McheckupListView";

    }

    @RequestMapping("/mcheckup/McheckupSelectUpdtView")
    public String mcheckupSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        CheckupManageVO checkupManageVO = mcheckupManageService.selectCheckup(selectedCd);

        log.info("checkupManageVO : " + checkupManageVO.toString());

        model.addAttribute("checkupManageVO", checkupManageVO);
        model.addAttribute("categoryId", checkupManageVO.getCategoryId());

        return "/mcheckup/McheckupSelectUpdtView";

    }


}
