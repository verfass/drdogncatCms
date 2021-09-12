package com.hplex.drdogncatcms.mchallenge.web;

import com.hplex.drdogncatcms.mchallenge.service.MchallengeDefaultVO;
import com.hplex.drdogncatcms.mchallenge.service.MchallengeManageService;
import com.hplex.drdogncatcms.mchallenge.service.MchallengeManageVO;
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
public class MchallengeManageController {

    private MchallengeManageService mchallengeManageService;

    @RequestMapping("/mchallenge/MchallengeList")
    public String mchallengeList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("mchallengeSearchVO") MchallengeDefaultVO mchallengeSearchVO,
            @ModelAttribute("mchallengeManageVO") MchallengeManageVO mchallengeManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        mchallengeSearchVO.setStrSubQuery(strSubQuery);
        mchallengeSearchVO.setOrderByQuery(orderByQuery);
        mchallengeSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = mchallengeManageService.selectMchallengeList(mchallengeSearchVO);

        model.addAttribute("resultList", resultList);

        return "/mchallenge/MchallengeListView";

    }

    @RequestMapping("/mchallenge/MchallengeInsertView")
    public String mchallengeInsertView(
            @ModelAttribute("mchallengeSearchVO") MchallengeDefaultVO mchallengeSearchVO,
            @ModelAttribute("mchallengeManageVO") MchallengeManageVO mchallengeManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        return "/mchallenge/MchallengeInsertView";

    }

    @RequestMapping("/mchallenge/MchallengeInsert")
    public String mchallengeInsert(
            @ModelAttribute("mchallengeManageVO") MchallengeManageVO mchallengeManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        mchallengeManageService.insertMchallenge(mchallengeManageVO);

        model.addAttribute("resultMsg", "입력 되었습니다.");

        return "forward:/mchallenge/MchallengeList";
    }


    @RequestMapping("/mchallenge/MchallengeSelectUpdtView")
    public String mchallengeSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        MchallengeManageVO mchallengeManageVO = mchallengeManageService.selectMchallenge(selectedCd);

        log.info("mchallengeManageVO : " + mchallengeManageVO.toString());

        model.addAttribute("mchallengeManageVO", mchallengeManageVO);

        return "/mchallenge/MchallengeSelectUpdtView";

    }

    @RequestMapping("/mchallenge/MchallengeSelectUpdt")
    public String mchallengeSelectUpdt(
            @ModelAttribute("mchallengeManageVO") MchallengeManageVO mchallengeManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        mchallengeManageService.updateMchallenge(mchallengeManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/mchallenge/MchallengeList";

    }
}
