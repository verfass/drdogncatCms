package com.hplex.drdogncatcms.msmt.web;

import com.hplex.drdogncatcms.msmt.service.MsmtDefaultVO;
import com.hplex.drdogncatcms.msmt.service.MsmtManageService;
import com.hplex.drdogncatcms.msmt.service.MsmtManageVO;
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
public class MsmtManageController {

    private MsmtManageService msmtManageService;

    @RequestMapping("/msmt/MsmtList")
    public String msmtList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("msmtSearchVO") MsmtDefaultVO msmtSearchVO,
            @ModelAttribute("msmtManageVO") MsmtManageVO msmtManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        msmtSearchVO.setStrSubQuery(strSubQuery);
        msmtSearchVO.setOrderByQuery(orderByQuery);
        msmtSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = msmtManageService.selectMsmtList(msmtSearchVO);

        model.addAttribute("list", resultList);

        return "/msmt/MsmtListView";

    }

    @RequestMapping("/msmt/MsmtSelectUpdtView")
    public String msmtSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        MsmtManageVO msmtManageVO = msmtManageService.selectMsmt(selectedCd);

        log.info("msmtManageVO : " + msmtManageVO.toString());

        model.addAttribute("msmtManageVO", msmtManageVO);

        return "/msmt/MsmtSelectUpdtView";

    }

    @RequestMapping("/msmt/MsmtSelectUpdt")
    public String msmtSelectUpdt(
            @ModelAttribute("msmtManageVO") MsmtManageVO msmtManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        msmtManageService.updateMsmt(msmtManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/msmt/MsmtList";

    }
}
