package com.hplex.drdogncatcms.present.web;

import com.hplex.drdogncatcms.present.service.PresentDefaultVO;
import com.hplex.drdogncatcms.present.service.PresentManageService;
import com.hplex.drdogncatcms.present.service.PresentManageVO;
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
public class PresentManageController {

    private PresentManageService presentManageService;

    @RequestMapping("/present/PresentList")
    public String presentList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("presentSearchVO") PresentDefaultVO presentSearchVO,
            @ModelAttribute("presentManageVO") PresentManageVO presentManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        presentSearchVO.setStrSubQuery(strSubQuery);
        presentSearchVO.setOrderByQuery(orderByQuery);
        presentSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = presentManageService.selectPresentList(presentSearchVO);

        model.addAttribute("resultList", resultList);

        return "/present/PresentListView";

    }

    @RequestMapping("/present/PresentInsertView")
    public String presentInsertView(
            @ModelAttribute("presentSearchVO") PresentDefaultVO presentSearchVO,
            @ModelAttribute("presentManageVO") PresentManageVO presentManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        return "/present/PresentInsertView";

    }

    @RequestMapping("/present/PresentInsert")
    public String presentInsert(
            @ModelAttribute("presentManageVO") PresentManageVO presentManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        presentManageService.insertPresent(presentManageVO);

        model.addAttribute("resultMsg", "입력 되었습니다.");

        return "forward:/present/PresentList";
    }


    @RequestMapping("/present/PresentSelectUpdtView")
    public String presentSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        PresentManageVO presentManageVO = presentManageService.selectPresent(selectedCd);

        log.info("presentManageVO : " + presentManageVO.toString());

        model.addAttribute("presentManageVO", presentManageVO);

        return "/present/PresentSelectUpdtView";

    }

    @RequestMapping("/present/PresentSelectUpdt")
    public String presentSelectUpdt(
            @ModelAttribute("presentManageVO") PresentManageVO presentManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        presentManageService.updatePresent(presentManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/present/PresentList";

    }
}
