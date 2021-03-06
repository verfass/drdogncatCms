package com.hplex.drdogncatcms.disease.web;

import com.hplex.drdogncatcms.disease.service.DiseaseDefaultVO;
import com.hplex.drdogncatcms.disease.service.DiseaseManageService;
import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;
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
public class DiseaseManageController {

    private DiseaseManageService diseaseManageService;

    @RequestMapping("/disease/DiseaseList")
    public String diseaseList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("diseaseSearchVO") DiseaseDefaultVO diseaseSearchVO,
            @ModelAttribute("diseaseManageVO") DiseaseManageVO diseaseManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        diseaseSearchVO.setStrSubQuery(strSubQuery);
        diseaseSearchVO.setOrderByQuery(orderByQuery);
        diseaseSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = diseaseManageService.selectDiseaseList(diseaseSearchVO);

        model.addAttribute("list", resultList);

        return "/disease/DiseaseListView";

    }

    @RequestMapping("/disease/DiseaseInsertView")
    public String diseaseInsertView(
            @ModelAttribute("diseaseSearchVO") DiseaseDefaultVO diseaseSearchVO,
            @ModelAttribute("diseaseManageVO") DiseaseManageVO diseaseManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        return "/disease/DiseaseInsertView";

    }

    @RequestMapping("/disease/DiseaseInsert")
    public String diseaseInsert(
            @ModelAttribute("diseaseManageVO") DiseaseManageVO diseaseManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        diseaseManageService.insertDisease(diseaseManageVO);

        model.addAttribute("resultMsg", "?????? ???????????????.");

        return "forward:/disease/DiseaseList";
    }


    @RequestMapping("/disease/DiseaseSelectUpdtView")
    public String diseaseSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        DiseaseManageVO diseaseManageVO = diseaseManageService.selectDisease(selectedCd);

        log.info("diseaseManageVO : " + diseaseManageVO.toString());

        model.addAttribute("diseaseManageVO", diseaseManageVO);

        return "/disease/DiseaseSelectUpdtView";

    }

    @RequestMapping("/disease/DiseaseSelectUpdt")
    public String diseaseSelectUpdt(
            @ModelAttribute("diseaseManageVO") DiseaseManageVO diseaseManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // ??????
        diseaseManageService.updateDisease(diseaseManageVO);

        model.addAttribute("resultMsg", "?????? ???????????????.");

        return "forward:/disease/DiseaseList";

    }

    @RequestMapping("/disease/DiseaseDelete")
    public String diseaseDelete(
            @ModelAttribute("diseaseManageVO") DiseaseManageVO diseaseManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // ??????
        diseaseManageService.deleteDisease(diseaseManageVO);

        model.addAttribute("resultMsg", "?????? ???????????????.");

        return "forward:/disease/DiseaseList";

    }
}
