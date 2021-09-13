package com.hplex.drdogncatcms.common.file.web;

import com.hplex.drdogncatcms.common.file.service.FileManageService;
import com.hplex.drdogncatcms.common.file.service.FileManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log4j2
@AllArgsConstructor
public class FileManageController {

    private FileManageService fileManageService;

    @RequestMapping(value="/SmartFileUploader")
    public String smartFileUploader(
            HttpServletRequest request,
            HttpServletResponse response,
            FileManageVO fileManageVO,
            Model model) throws Exception {


        return "";
    }

}
