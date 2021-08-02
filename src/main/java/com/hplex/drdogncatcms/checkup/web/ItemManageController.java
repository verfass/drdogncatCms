package com.hplex.drdogncatcms.checkup.web;

import com.hplex.drdogncatcms.checkup.service.ItemDefaultVO;
import com.hplex.drdogncatcms.checkup.service.ItemManageService;
import com.hplex.drdogncatcms.checkup.service.ItemManageVO;
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

    @RequestMapping("/checkup/ItemList")
    public String itemList(
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("itemSearchVO") ItemDefaultVO itemSearchVO,
            @ModelAttribute("itemManageVO") ItemManageVO itemManageVO,
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.info("itemList start ====================== ");

        List<ItemManageVO> resultList = itemManageService.selectItemList(selectedCd);

        model.addAttribute("list", resultList);
        model.addAttribute("selectedCd", selectedCd);

        return "/checkup/ItemListView";
    }

    @RequestMapping("/checkup/ItemSelectUpdtView")
    public String itemSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.info("itemSelectUpdtView start ====================== ");

        ItemManageVO itemManageVO = itemManageService.selectItem(selectedCd);

        log.info("itemManageVO : " + itemManageVO.toString());

        model.addAttribute("itemManageVO", itemManageVO);

        return "/checkup/ItemSelectUpdtView";

    }

    @RequestMapping("/checkup/ItemSelectUpdt")
    public String itemSelectUpdt(
            @ModelAttribute("itemManageVO") ItemManageVO itemManageVO,
            Model model) throws Exception {

        log.info("itemSelectUpdt start ====================== ");

        // 저장
        itemManageService.updateItem(itemManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/checkup/ItemList?selectCd="+itemManageVO.getParentId();

    }




}
