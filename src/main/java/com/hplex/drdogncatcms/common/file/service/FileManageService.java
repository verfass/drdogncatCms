package com.hplex.drdogncatcms.common.file.service;

import com.hplex.drdogncatcms.disease.service.DiseaseDefaultVO;
import com.hplex.drdogncatcms.disease.service.DiseaseManageVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface FileManageService {

    // select list
    public List<?> selectFileList(FileDefaultVO fileSearchVO) throws Exception;

    // select one
    public FileManageVO selectFile(String sSeq, String type) throws Exception;

    // update one
    public void updateFile(FileManageVO fileManageVO) throws Exception;

    // insert one
    public void insertFile(FileManageVO fileManageVO) throws Exception;


    // save file
    public String saveFile(FileManageVO fileManageVO) throws Exception;

    public File convertFile(MultipartFile mfile) throws Exception;

    public boolean isPermisionFileMimeType(MultipartFile file) throws Exception;

}