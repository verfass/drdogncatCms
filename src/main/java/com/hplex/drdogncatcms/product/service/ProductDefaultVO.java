package com.hplex.drdogncatcms.product.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductDefaultVO implements Serializable {

    private static final long serialVersionUID = -2543032057806936858L;

    private String searchKeyword = "";
    private String searchChkAt = "";
    private String strSubQuery = "";
    private String groupByQuery = "";
    private String orderByQuery = "";

    /** 현재페이지 */
    private int pageIndex = 1;
    /** 페이지갯수 */
    private int pageUnit = 10;
    /** 페이지사이즈 */
    private int pageSize = 10;
    /** firstIndex */
    private int firstIndex = 1;
    /** lastIndex */
    private int lastIndex = 1;
    /** recordCountPerPage */
    private int recordCountPerPage = 10;

}
