package com.hplex.drdogncatcms.common.file.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class FileManageVO extends FileDefaultVO {

    private static final long serialVersionUID = 953656482741796827L;

    private String seq;
    private String sSeq;
    private String type;
    private String originFileName;
    private String saveFileName;
    private String fileSize;
    private String delAt;
    private MultipartFile filedata;

}
