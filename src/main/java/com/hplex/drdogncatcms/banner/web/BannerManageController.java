package com.hplex.drdogncatcms.banner.web;

import com.hplex.drdogncatcms.banner.service.BannerDefaultVO;
import com.hplex.drdogncatcms.banner.service.BannerManageService;
import com.hplex.drdogncatcms.banner.service.BannerManageVO;
import com.hplex.drdogncatcms.common.file.service.FileManageService;
import com.hplex.drdogncatcms.common.file.service.FileManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Log4j2
public class BannerManageController {

    @Autowired
    private BannerManageService bannerManageService;

    @Autowired
    private FileManageService fileService;

    @Value("${file.url}")
    private String fileUrl;

    private String type = "banner";

    @RequestMapping("/banner/BannerList")
    public String bannerList (
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("bannerSearchVO") BannerDefaultVO bannerSearchVO,
            @ModelAttribute("bannerManageVO") BannerManageVO bannerManageVO,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        String strSubQuery = "";
        String orderByQuery = "";
        String groupByQuery = "";
        orderByQuery = orderByQuery + " seq DESC ";

        bannerSearchVO.setStrSubQuery(strSubQuery);
        bannerSearchVO.setOrderByQuery(orderByQuery);
        bannerSearchVO.setGroupByQuery(groupByQuery);

        List<?> resultList = bannerManageService.selectBannerList(bannerSearchVO);

        model.addAttribute("resultList", resultList);
        model.addAttribute("fileUrl", fileUrl);

        return "/banner/BannerListView";

    }

    @RequestMapping("/banner/BannerInsertView")
    public String bannerInsertView(
            @ModelAttribute("bannerSearchVO") BannerDefaultVO bannerSearchVO,
            @ModelAttribute("bannerManageVO") BannerManageVO bannerManageVO,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        return "/banner/BannerInsertView";

    }

    @RequestMapping("/banner/BannerInsert")
    public String bannerInsert(
            @ModelAttribute("bannerManageVO") BannerManageVO bannerManageVO,
            @RequestParam(value="file", required=false) MultipartFile file,
            Model model
    )throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        log.debug("file : " + file);
        log.debug("file : " + file.toString());

        String resultMsg = "";
        String saveFileName = "";

        String sSeq = bannerManageService.insertBanner(bannerManageVO);

        if (!file.isEmpty()) {

            if (fileService.isPermisionFileMimeType(file)) {
                // 파일 저장
                FileManageVO fileManageVO = new FileManageVO();
                fileManageVO.setFiledata(file);
                fileManageVO.setSSeq(sSeq);
                fileManageVO.setType(type);
                saveFileName = fileService.saveFile(fileManageVO);

                bannerManageVO = bannerManageService.selectBanner(sSeq);
                bannerManageVO.setBannerImg(saveFileName);
                bannerManageService.updateBanner(bannerManageVO);
            }
        }

        resultMsg = "입력 되었습니다.";
        model.addAttribute("resultMsg", resultMsg);

        return "forward:/banner/BannerList";
    }


    @RequestMapping("/banner/BannerSelectUpdtView")
    public String bannerSelectUpdtView(
            @RequestParam(value="selectedCd", defaultValue="101") String selectedCd,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        BannerManageVO bannerManageVO = bannerManageService.selectBanner(selectedCd);

        log.info("bannerManageVO : " + bannerManageVO.toString());

        model.addAttribute("bannerManageVO", bannerManageVO);
        model.addAttribute("fileUrl", fileUrl);

        return "/banner/BannerSelectUpdtView";

    }

    @RequestMapping("/banner/BannerSelectUpdt")
    public String bannerSelectUpdt(
            @ModelAttribute("bannerManageVO") BannerManageVO bannerManageVO,
            @RequestParam(value="file", required=false) MultipartFile file,
            Model model) throws Exception {

        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + " Start =========================");

        log.debug("file : " + file);
        log.debug("file : " + file.toString());

        String resultMsg = "";
        String saveFileName = "";

        String sSeq = bannerManageVO.getSeq();

        if (!file.isEmpty()) {

            if (fileService.isPermisionFileMimeType(file)) {
                // 파일 저장
                FileManageVO fileManageVO = new FileManageVO();
                fileManageVO.setFiledata(file);
                fileManageVO.setSSeq(sSeq);
                fileManageVO.setType(type);
                saveFileName = fileService.saveFile(fileManageVO);

                bannerManageVO.setBannerImg(saveFileName);
            }
        }

        // 저장
        bannerManageService.updateBanner(bannerManageVO);

        model.addAttribute("resultMsg", "수정 되었습니다.");

        return "forward:/banner/BannerList";

    }
}
