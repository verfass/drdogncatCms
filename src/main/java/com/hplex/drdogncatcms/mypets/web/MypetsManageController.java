package com.hplex.drdogncatcms.mypets.web;

import com.hplex.drdogncatcms.mypets.service.MypetsDefaultVO;
import com.hplex.drdogncatcms.mypets.service.MypetsManageService;
import com.hplex.drdogncatcms.mypets.service.MypetsManageVO;
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
public class MypetsManageController {

    private MypetsManageService mypetsManageService;

    @RequestMapping("/mypets/MypetsList")
    public String mypetsList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("mypetsSearchVO") MypetsDefaultVO mypetsSearchVO,
            @ModelAttribute("mypetsManageVO") MypetsManageVO mypetsManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        mypetsSearchVO.setStrSubQuery(strSubQuery);
        mypetsSearchVO.setOrderByQuery(orderByQuery);
        mypetsSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = mypetsManageService.selectMypetsList(mypetsSearchVO);

        model.addAttribute("resultList", resultList);

        return "/mypets/MypetsListView";

    }

    @RequestMapping("/mypets/MypetsSelectUpdtView")
    public String mypetsSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        MypetsManageVO mypetsManageVO = mypetsManageService.selectMypets(selectedCd);

        log.info("mypetsManageVO : " + mypetsManageVO.toString());

        model.addAttribute("mypetsManageVO", mypetsManageVO);

        return "/mypets/MypetsSelectUpdtView";

    }

    @RequestMapping("/mypets/MypetsSelectUpdt")
    public String mypetsSelectUpdt(
            @ModelAttribute("mypetsManageVO") MypetsManageVO mypetsManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        mypetsManageService.updateMypets(mypetsManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/mypets/MypetsList";

    }

}
