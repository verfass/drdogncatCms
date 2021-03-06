package com.hplex.drdogncatcms.member.web;

import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;
import com.hplex.drdogncatcms.member.service.MemberDefaultVO;
import com.hplex.drdogncatcms.member.service.MemberManageService;
import com.hplex.drdogncatcms.member.service.MemberManageVO;
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
public class MemberManageController {

    private MemberManageService memberManageService;

    @RequestMapping("/member/MemberList")
    public String memberList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("memberSearchVO") MemberDefaultVO memberSearchVO,
            @ModelAttribute("memberManageVO") MemberManageVO memberManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        memberSearchVO.setStrSubQuery(strSubQuery);
        memberSearchVO.setOrderByQuery(orderByQuery);
        memberSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = memberManageService.selectMemberList(memberSearchVO);

        model.addAttribute("resultList", resultList);

        return "/member/MemberListView";

    }

    @RequestMapping("/member/MemberSelectUpdtView")
    public String memberSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        MemberManageVO memberManageVO = memberManageService.selectMember(selectedCd);

        log.info("memberManageVO : " + memberManageVO.toString());

        model.addAttribute("memberManageVO", memberManageVO);

        return "/member/MemberSelectUpdtView";

    }

    @RequestMapping("/member/MemberSelectUpdt")
    public String memberSelectUpdt(
            @ModelAttribute("memberManageVO") MemberManageVO memberManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // ??????
        memberManageService.updateMember(memberManageVO);

        model.addAttribute("resultMsg", "?????? ???????????????.");

        return "forward:/member/MemberList";

    }

}
