package com.hplex.drdogncatcms.inform.web;

import com.hplex.drdogncatcms.inform.service.InformDefaultVO;
import com.hplex.drdogncatcms.inform.service.InformManageService;
import com.hplex.drdogncatcms.inform.service.InformManageVO;
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
public class InformManageController {

    private InformManageService informManageService;

    @RequestMapping("/inform/InformList")
    public String informList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("informSearchVO") InformDefaultVO informSearchVO,
            @ModelAttribute("informManageVO") InformManageVO informManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        informSearchVO.setStrSubQuery(strSubQuery);
        informSearchVO.setOrderByQuery(orderByQuery);
        informSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = informManageService.selectInformList(informSearchVO);

        model.addAttribute("resultList", resultList);

        return "/inform/InformListView";

    }

    @RequestMapping("/inform/InformInsertView")
    public String informInsertView(
            @ModelAttribute("informSearchVO") InformDefaultVO informSearchVO,
            @ModelAttribute("informManageVO") InformManageVO informManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        return "/inform/InformInsertView";

    }

    @RequestMapping("/inform/InformInsert")
    public String informInsert(
            @ModelAttribute("informManageVO") InformManageVO informManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        informManageService.insertInform(informManageVO);

        model.addAttribute("resultMsg", "입력 되었습니다.");

        return "forward:/inform/InformList";
    }


    @RequestMapping("/inform/InformSelectUpdtView")
    public String informSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        InformManageVO informManageVO = informManageService.selectInform(selectedCd);

        log.info("informManageVO : " + informManageVO.toString());

        model.addAttribute("informManageVO", informManageVO);

        return "/inform/InformSelectUpdtView";

    }

    @RequestMapping("/inform/InformSelectUpdt")
    public String informSelectUpdt(
            @ModelAttribute("informManageVO") InformManageVO informManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        informManageService.updateInform(informManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/inform/InformList";

    }
}
