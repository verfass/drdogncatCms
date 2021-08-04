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
public class FileManageVO implements Serializable {

    private static final long serialVersionUID = 953656482741796827L;

    private MultipartFile filedata;
    private String callback;
    private String callback_func;

}
