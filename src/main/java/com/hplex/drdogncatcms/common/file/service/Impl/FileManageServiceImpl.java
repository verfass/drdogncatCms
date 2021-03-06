package com.hplex.drdogncatcms.common.file.service.Impl;

import com.hplex.drdogncatcms.common.file.service.FileManageService;
import com.hplex.drdogncatcms.common.file.service.FileManageVO;
import com.hplex.drdogncatcms.common.file.service.FileDefaultVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service("fileManageService")
@Log4j2
public class FileManageServiceImpl implements FileManageService {

    @Autowired
    private FileManageDAO fileManageDAO;

    @Value("${file.minetype}")
    private String[] ableMinetype;

    @Value("${file.directory}")
    private String fileDirectory;

    // select list
    @Override
    public List<?> selectFileList(FileDefaultVO fileSearchVO) throws Exception {
        return fileManageDAO.selectFileList(fileSearchVO);
    }

    // select one
    @Override
    public FileManageVO selectFile(String sSeq, String type) throws Exception {

        HashMap map = new HashMap();
        map.put("sSeq", sSeq);
        map.put("type", type);

        return fileManageDAO.selectFile(map);
    }

    // update one
    @Override
    public void updateFile(FileManageVO fileManageVO) throws Exception {
        fileManageDAO.updateFile(fileManageVO);
    }

    // insert one
    @Override
    public void insertFile(FileManageVO fileManageVO) throws Exception {
        fileManageDAO.insertFile(fileManageVO);
    }


    // save file
    @Override
    public String saveFile(FileManageVO fileManageVO) throws Exception {

        MultipartFile file = fileManageVO.getFiledata();

        String ret = "";

        if (!file.isEmpty()) {

            String uuid = UUID.randomUUID().toString().replaceAll("-", "");

            String orginFileName = file.getOriginalFilename();
            String extension = StringUtils.getFilenameExtension(orginFileName);
            String fileSize = String.valueOf(file.getSize());
            String saveFileName = fileManageVO.getSSeq() + "." + extension;
            String type = fileManageVO.getType();

            log.debug("orginFileName : " + orginFileName);
            log.debug("extension : " + extension);
            log.debug("fileSize : " + fileSize);
            log.debug("saveFileName : " + saveFileName);
            log.debug("type : " + type);

            String uploadPath = fileDirectory + type + "/";
            String uploadFile = uploadPath + saveFileName;
            File destdir = new File(uploadPath); //???????????? ????????????

            log.debug("fileDirectory : " + fileDirectory);
            log.debug("uploadPath : " + uploadPath);
            log.debug("uploadFile : " + uploadFile);

            if(!destdir.exists()){
                destdir.mkdirs(); //??????????????? ???????????? ???????????? ??????
            }

            log.debug("?????? ?????? ?????? : " + uploadFile);
            file.transferTo(new File(uploadFile));

            fileManageVO.setOriginFileName(orginFileName);
            fileManageVO.setSaveFileName(saveFileName);
            fileManageVO.setFileSize(fileSize);
            fileManageVO.setDelAt("0");

            ret = "/" + type + "/" + saveFileName;

            log.debug("ret : " + ret);



        }

        return ret;
    }

    /**
     * MultipartFile ??? File ??? ??????
     *
     * @param mfile
     * @return File
     * @throws Exception
     */
    @Override
    public File convertFile(MultipartFile mfile) throws Exception {
        File file = new File(mfile.getOriginalFilename());
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(mfile.getBytes());
        fos.close();
        return file;
    }

    /**
     * MultipartFile??? ?????? ????????? MIMETYPE??? ?????? ????????????
     * true : ??????
     * false : ??????
     *
     * @param file
     * @return boolean
     * @throws Exception
     */
//    @Override
//    public boolean isPermisionFileMimeType(MultipartFile file) throws Exception {
//        final String[] PERMISSION_FILE_MIME_TYPE = ableMinetype;
//        String mimeType = new Tika().detect(convertFile(file));
//        boolean isPermisionFileMimeType = false;
//        for( int i = 0; i < PERMISSION_FILE_MIME_TYPE.length; i++ ) {
//            if( PERMISSION_FILE_MIME_TYPE[i].equals(mimeType) ) {
//                isPermisionFileMimeType = true;
//                break;
//            }
//        }
//        return isPermisionFileMimeType;
//    }

}
