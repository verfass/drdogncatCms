package com.hplex.drdogncatcms.notice.service.Impl;

import com.hplex.drdogncatcms.notice.service.Impl.NoticeManageDAO;
import com.hplex.drdogncatcms.notice.service.NoticeDefaultVO;
import com.hplex.drdogncatcms.notice.service.NoticeManageService;
import com.hplex.drdogncatcms.notice.service.NoticeManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeManageService")
@Log4j2
@AllArgsConstructor
public class NoticeManageServiceImpl implements NoticeManageService {

    @Autowired
    private NoticeManageDAO noticeManageDAO;

    // select list
    @Override
    public List<?> selectNoticeList(NoticeDefaultVO noticeSearchVO) throws Exception {
        return noticeManageDAO.selectNoticeList(noticeSearchVO);
    }

    // select one
    @Override
    public NoticeManageVO selectNotice(String seq) throws Exception {
        return noticeManageDAO.selectNotice(seq);
    }

    // insert one
    @Override
    public int insertNotice(NoticeManageVO noticeManageVO) throws Exception {
        return noticeManageDAO.insertNotice(noticeManageVO);
    }

    // update one
    @Override
    public void updateNotice(NoticeManageVO noticeManageVO) throws Exception {
        noticeManageDAO.updateNotice(noticeManageVO);
    }

    // delete one
    @Override
    public void deleteNotice(String itemId) throws Exception {
        noticeManageDAO.deleteNotice(itemId);
    }

}
