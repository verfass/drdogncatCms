package com.hplex.drdogncatcms.challenge.web;

import com.hplex.drdogncatcms.challenge.service.ChallengeDefaultVO;
import com.hplex.drdogncatcms.challenge.service.ChallengeManageService;
import com.hplex.drdogncatcms.challenge.service.ChallengeManageVO;
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
public class ChallengeManageController {

    private ChallengeManageService challengeManageService;

    @RequestMapping("/challenge/ChallengeList")
    public String challengeList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("challengeSearchVO") ChallengeDefaultVO challengeSearchVO,
            @ModelAttribute("challengeManageVO") ChallengeManageVO challengeManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        challengeSearchVO.setStrSubQuery(strSubQuery);
        challengeSearchVO.setOrderByQuery(orderByQuery);
        challengeSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = challengeManageService.selectChallengeList(challengeSearchVO);

        model.addAttribute("resultList", resultList);

        return "/challenge/ChallengeListView";

    }

    @RequestMapping("/challenge/ChallengeInsertView")
    public String challengeInsertView(
            @ModelAttribute("challengeSearchVO") ChallengeDefaultVO challengeSearchVO,
            @ModelAttribute("challengeManageVO") ChallengeManageVO challengeManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        return "/challenge/ChallengeInsertView";

    }

    @RequestMapping("/challenge/ChallengeInsert")
    public String challengeInsert(
            @ModelAttribute("challengeManageVO") ChallengeManageVO challengeManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        challengeManageService.insertChallenge(challengeManageVO);

        model.addAttribute("resultMsg", "입력 되었습니다.");

        return "forward:/challenge/ChallengeList";
    }


    @RequestMapping("/challenge/ChallengeSelectUpdtView")
    public String challengeSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        ChallengeManageVO challengeManageVO = challengeManageService.selectChallenge(selectedCd);

        log.info("challengeManageVO : " + challengeManageVO.toString());

        model.addAttribute("challengeManageVO", challengeManageVO);

        return "/challenge/ChallengeSelectUpdtView";

    }

    @RequestMapping("/challenge/ChallengeSelectUpdt")
    public String challengeSelectUpdt(
            @ModelAttribute("challengeManageVO") ChallengeManageVO challengeManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        challengeManageService.updateChallenge(challengeManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/challenge/ChallengeList";

    }
}
