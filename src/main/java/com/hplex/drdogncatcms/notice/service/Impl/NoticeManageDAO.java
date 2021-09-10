package com.hplex.drdogncatcms.notice.service.Impl;

import com.hplex.drdogncatcms.notice.service.NoticeDefaultVO;
import com.hplex.drdogncatcms.notice.service.NoticeManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NoticeManageDAO {

    // select list
    public List<?> selectNoticeList(NoticeDefaultVO noticeSearchVO);

    // select one
    public NoticeManageVO selectNotice(String seq);

    // insert one
    public int insertNotice(NoticeManageVO noticeManageVO);

    // update one
    public void updateNotice(NoticeManageVO noticeManageVO);

    // delete one
    public void deleteNotice(String itemId);

}
