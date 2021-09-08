package com.hplex.drdogncatcms.admin.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class AdminManageVO extends AdminDefaultVO {

    private static final long serialVersionUID = 2169757533791926406L;

    private String seq;
    private String id;
    private String pw;
    private String name;
    private String phone;
    private String email;
    private String role;
    private String chkAt;

}
