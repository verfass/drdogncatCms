package com.hplex.drdogncatcms.checkup.web;

import com.hplex.drdogncatcms.checkup.service.ItemDefaultVO;
import com.hplex.drdogncatcms.checkup.service.ItemManageService;
import com.hplex.drdogncatcms.checkup.service.ItemManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log4j2
@AllArgsConstructor
public class ItemManageController {

    private ItemManageService itemManageService;

    @GetMapping("/checkup/item")
    public String item(
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("itemSearchVO") ItemDefaultVO itemSearchVO,
            @ModelAttribute("itemManageVO") ItemManageVO itemManageVO,
            @RequestParam(value="SCMID", defaultValue="") String SCMID,
            Model model) throws Exception {


        return "";
    }


}
