package com.hplex.drdogncatcms.role.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class RoleManageVO extends RoleDefaultVO {

    private static final long serialVersionUID = 5212953390072725510L;

    private String seq;
    private String role;
    private String roleName;

}
