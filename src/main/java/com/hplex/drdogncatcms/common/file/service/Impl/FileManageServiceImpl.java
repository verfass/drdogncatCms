package com.hplex.drdogncatcms.common.file.service.Impl;

import com.hplex.drdogncatcms.common.file.service.FileManageService;
import com.hplex.drdogncatcms.common.file.service.FileManageVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service("fileManageService")
@Log4j2
@AllArgsConstructor
public class FileManageServiceImpl implements FileManageService {

    // save file
    @Override
    public String saveFile(FileManageVO fileManageVO) throws Exception {
        return "";
    };

    // save files
    @Override
    public String saveFiles(FileManageVO fileManageVO) throws Exception {
        return "";
    };

}
