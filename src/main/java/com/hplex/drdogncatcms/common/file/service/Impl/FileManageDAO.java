package com.hplex.drdogncatcms.common.file.service.Impl;

import com.hplex.drdogncatcms.common.file.service.FileDefaultVO;
import com.hplex.drdogncatcms.common.file.service.FileManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface FileManageDAO {

    // select list
    public List<?> selectFileList(FileDefaultVO fileSearchVO);

    // select one
    public FileManageVO selectFile(HashMap<String, String> map);

    // update one
    public void updateFile(FileManageVO fileManageVO);

    // insert one
    public void insertFile(FileManageVO fileManageVO);
}
