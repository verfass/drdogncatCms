package com.hplex.drdogncatcms.common.file.service;

import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;

public interface FileManageService {

    // save file
    public String saveFile(FileManageVO fileManageVO) throws Exception;

    // save files
    public String saveFiles(FileManageVO fileManageVO) throws Exception;
}
