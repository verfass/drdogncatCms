package com.hplex.drdogncatcms.notice.service;

import java.util.List;

public interface NoticeManageService {

    // select list
    public List<?> selectNoticeList(NoticeDefaultVO noticeSearchVO) throws Exception;

    // select one
    public NoticeManageVO selectNotice(String seq) throws Exception;

    // insert one
    public int insertNotice(NoticeManageVO noticeManageVO) throws Exception;

    // update one
    public void updateNotice(NoticeManageVO noticeManageVO) throws Exception;

    // delete one
    public void deleteNotice(String itemId) throws Exception;

}
