package com.hplex.drdogncatcms.role.web;

import com.hplex.drdogncatcms.disease.service.DiseaseDefaultVO;
import com.hplex.drdogncatcms.disease.service.DiseaseManageService;
import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;
import com.hplex.drdogncatcms.role.service.RoleDefaultVO;
import com.hplex.drdogncatcms.role.service.RoleManageService;
import com.hplex.drdogncatcms.role.service.RoleManageVO;
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
public class RoleManageController {

    private RoleManageService roleManageService;

    @RequestMapping("/role/RoleList")
    public String roleList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("roleSearchVO") RoleDefaultVO roleSearchVO,
            @ModelAttribute("roleManageVO") RoleManageVO roleManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        roleSearchVO.setStrSubQuery(strSubQuery);
        roleSearchVO.setOrderByQuery(orderByQuery);
        roleSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = roleManageService.selectRoleList(roleSearchVO);

        model.addAttribute("resultList", resultList);

        return "/role/RoleListView";

    }

    @RequestMapping("/role/RoleInsertView")
    public String roleInsertView(
            @ModelAttribute("roleSearchVO") RoleDefaultVO roleSearchVO,
            @ModelAttribute("roleManageVO") RoleManageVO roleManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        return "/role/RoleInsertView";

    }

    @RequestMapping("/role/RoleInsert")
    public String roleInsert(
            @ModelAttribute("roleManageVO") RoleManageVO roleManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        roleManageService.insertRole(roleManageVO);

        model.addAttribute("resultMsg", "입력 되었습니다.");

        return "forward:/role/RoleList";
    }


    @RequestMapping("/role/RoleSelectUpdtView")
    public String roleSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        RoleManageVO roleManageVO = roleManageService.selectRole(selectedCd);

        log.info("roleManageVO : " + roleManageVO.toString());

        model.addAttribute("roleManageVO", roleManageVO);

        return "/role/RoleSelectUpdtView";

    }

    @RequestMapping("/role/RoleSelectUpdt")
    public String roleSelectUpdt(
            @ModelAttribute("roleManageVO") RoleManageVO roleManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        roleManageService.updateRole(roleManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/role/RoleList";

    }
}
