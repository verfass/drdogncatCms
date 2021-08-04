package com.hplex.drdogncatcms.checkup.web;

import com.hplex.drdogncatcms.checkup.service.ItemDefaultVO;
import com.hplex.drdogncatcms.checkup.service.ItemManageService;
import com.hplex.drdogncatcms.checkup.service.ItemManageVO;
import com.hplex.drdogncatcms.disease.service.*;
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
public class ItemManageController {

    private ItemManageService itemManageService;
    private DiseaseManageService diseaseManageService;
    private DiseaseRefManageService diseaseRefManageService;

    @RequestMapping("/checkup/ItemList")
    public String itemList(
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("itemSearchVO") ItemDefaultVO itemSearchVO,
            @ModelAttribute("itemManageVO") ItemManageVO itemManageVO,
            @RequestParam(value="categoryId", defaultValue="101") String categoryId,
            Model model) throws Exception {

        log.info("itemList start ====================== ");

        itemSearchVO.setSearchCategoryId(categoryId);
        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " id ASC ";

        itemSearchVO.setStrSubQuery(strSubQuery);
        itemSearchVO.setOrderByQuery(orderByQuery);
        itemSearchVO.setGroupByQuery(groupByQuery);
        List<?> resultList = itemManageService.selectItemList(itemSearchVO);

        model.addAttribute("resultList", resultList);
        model.addAttribute("categoryId", categoryId);

        return "/checkup/ItemListView";
    }

    @RequestMapping("/checkup/ItemSelectUpdtView")
    public String itemSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.info("itemSelectUpdtView start ====================== ");

        ItemManageVO itemManageVO = itemManageService.selectItem(selectedCd);

        log.info("itemManageVO : " + itemManageVO.toString());

        // 질병 설정 목록 가져오기
        DiseaseRefDefaultVO diseaseRefSearchVO = new DiseaseRefDefaultVO();
        diseaseRefSearchVO.setSearchItemId(itemManageVO.getId());
        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " dis.seq ASC ";
        diseaseRefSearchVO.setStrSubQuery(strSubQuery);
        diseaseRefSearchVO.setOrderByQuery(orderByQuery);
        diseaseRefSearchVO.setGroupByQuery(groupByQuery);
        List<?> diseaseRefList = diseaseRefManageService.selectDiseaseRefList(diseaseRefSearchVO);

        // 질병 전체 목록 가져오기
        DiseaseDefaultVO diseaseSearchVO = new DiseaseDefaultVO();
        strSubQuery = "";
        orderByQuery = "";
        groupByQuery = "";
        orderByQuery = orderByQuery + " seq ASC ";
        diseaseSearchVO.setStrSubQuery(strSubQuery);
        diseaseSearchVO.setOrderByQuery(orderByQuery);
        diseaseSearchVO.setGroupByQuery(groupByQuery);
        List<?> diseaseList = diseaseManageService.selectDiseaseList(diseaseSearchVO);

        model.addAttribute("diseaseRefList", diseaseRefList);
        model.addAttribute("diseaseList", diseaseList);
        model.addAttribute("itemManageVO", itemManageVO);

        return "/checkup/ItemSelectUpdtView";

    }

    @RequestMapping("/checkup/ItemSelectUpdt")
    public String itemSelectUpdt(
            @ModelAttribute("itemManageVO") ItemManageVO itemManageVO,
            Model model) throws Exception {

        log.info("itemSelectUpdt start ====================== ");

        // 질병목록 처리
        diseaseRefManageService.deleteDiseaseRef(itemManageVO.getId());
        DiseaseRefManageVO diseaseRefManageVO = new DiseaseRefManageVO();
        diseaseRefManageVO.setItemId(itemManageVO.getId());
        String [] selCd = itemManageVO.getDiseases().split(",");
        if (selCd.length > 0) {
            for (int i = 0; i < selCd.length; i++) {
                String[] cd = selCd[i].split("\\.");
//            Integer cnt = diseaseRefManageService.selectDiseaseCnt(itemManageVO.getId(), cd[0]);
//            if (cnt == null || cnt < 1) {
                if (cd.length > 1) {
                    diseaseRefManageVO.setDiseaseId(cd[0]);
                    diseaseRefManageService.insertDiseaseRef(diseaseRefManageVO);
                }
//            }
            }
        }

        // 저장
        itemManageService.updateItem(itemManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        log.info("itemManageVO.getCategoryId() : " + itemManageVO.getCategoryId());

        return "forward:/checkup/ItemList?categoryId="+itemManageVO.getCategoryId();

    }




}
