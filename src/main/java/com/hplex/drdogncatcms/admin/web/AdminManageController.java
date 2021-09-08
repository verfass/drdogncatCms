package com.hplex.drdogncatcms.admin.web;

import com.hplex.drdogncatcms.admin.service.AdminDefaultVO;
import com.hplex.drdogncatcms.admin.service.AdminManageService;
import com.hplex.drdogncatcms.admin.service.AdminManageVO;
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
public class AdminManageController {

    private AdminManageService adminManageService;
    private RoleManageService roleManageService;

    @RequestMapping("/admin/AdminList")
    public String adminList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("adminSearchVO") AdminDefaultVO adminSearchVO,
            @ModelAttribute("adminManageVO") AdminManageVO adminManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        adminSearchVO.setStrSubQuery(strSubQuery);
        adminSearchVO.setOrderByQuery(orderByQuery);
        adminSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = adminManageService.selectAdminList(adminSearchVO);
        model.addAttribute("resultList", resultList);

        //권한
        RoleDefaultVO roleSearchVO = new RoleDefaultVO();
        roleSearchVO.setOrderByQuery(" role ASC ");
        List<?> roleList = roleManageService.selectRoleList(roleSearchVO);
        model.addAttribute("roleList", roleList);

        return "/admin/AdminListView";

    }

    @RequestMapping("/admin/AdminInsertView")
    public String adminInsertView(
            @ModelAttribute("adminSearchVO") AdminDefaultVO adminSearchVO,
            @ModelAttribute("adminManageVO") AdminManageVO adminManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        //권한
        RoleDefaultVO roleSearchVO = new RoleDefaultVO();
        roleSearchVO.setOrderByQuery(" role ASC ");
        List<?> roleList = roleManageService.selectRoleList(roleSearchVO);
        model.addAttribute("roleList", roleList);

        return "/admin/AdminInsertView";

    }

    @RequestMapping("/admin/AdminInsert")
    public String adminInsert(
            @ModelAttribute("adminManageVO") AdminManageVO adminManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        adminManageService.insertAdmin(adminManageVO);

        model.addAttribute("resultMsg", "입력 되었습니다.");

        return "forward:/admin/AdminList";
    }


    @RequestMapping("/admin/AdminSelectUpdtView")
    public String adminSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        AdminManageVO adminManageVO = adminManageService.selectAdmin(selectedCd);

        log.info("adminManageVO : " + adminManageVO.toString());

        model.addAttribute("adminManageVO", adminManageVO);

        //권한
        RoleDefaultVO roleSearchVO = new RoleDefaultVO();
        roleSearchVO.setOrderByQuery(" role ASC ");
        List<?> roleList = roleManageService.selectRoleList(roleSearchVO);
        model.addAttribute("roleList", roleList);

        return "/admin/AdminSelectUpdtView";

    }

    @RequestMapping("/admin/AdminSelectUpdt")
    public String adminSelectUpdt(
            @ModelAttribute("adminManageVO") AdminManageVO adminManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        // 저장
        adminManageService.updateAdmin(adminManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/admin/AdminList";

    }
}
