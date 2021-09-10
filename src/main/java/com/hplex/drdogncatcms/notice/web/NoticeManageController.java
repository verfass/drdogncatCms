package com.hplex.drdogncatcms.notice.web;

import com.hplex.drdogncatcms.notice.service.NoticeDefaultVO;
import com.hplex.drdogncatcms.notice.service.NoticeManageService;
import com.hplex.drdogncatcms.notice.service.NoticeManageVO;
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
public class NoticeManageController {

    private NoticeManageService noticeManageService;

    @RequestMapping("/notice/NoticeList")
    public String noticeList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("noticeSearchVO") NoticeDefaultVO noticeSearchVO,
            @ModelAttribute("noticeManageVO") NoticeManageVO noticeManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        noticeSearchVO.setStrSubQuery(strSubQuery);
        noticeSearchVO.setOrderByQuery(orderByQuery);
        noticeSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = noticeManageService.selectNoticeList(noticeSearchVO);

        model.addAttribute("resultList", resultList);

        return "/notice/NoticeListView";

    }

    @RequestMapping("/notice/NoticeInsertView")
    public String noticeInsertView(
            @ModelAttribute("noticeSearchVO") NoticeDefaultVO noticeSearchVO,
            @ModelAttribute("noticeManageVO") NoticeManageVO noticeManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        return "/notice/NoticeInsertView";

    }

    @RequestMapping("/notice/NoticeInsert")
    public String noticeInsert(
            @ModelAttribute("noticeManageVO") NoticeManageVO noticeManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        noticeManageService.insertNotice(noticeManageVO);

        model.addAttribute("resultMsg", "입력 되었습니다.");

        return "forward:/notice/NoticeList";
    }


    @RequestMapping("/notice/NoticeSelectUpdtView")
    public String noticeSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        NoticeManageVO noticeManageVO = noticeManageService.selectNotice(selectedCd);

        log.info("noticeManageVO : " + noticeManageVO.toString());

        model.addAttribute("noticeManageVO", noticeManageVO);

        return "/notice/NoticeSelectUpdtView";

    }

    @RequestMapping("/notice/NoticeSelectUpdt")
    public String noticeSelectUpdt(
            @ModelAttribute("noticeManageVO") NoticeManageVO noticeManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        noticeManageService.updateNotice(noticeManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/notice/NoticeList";

    }
}
