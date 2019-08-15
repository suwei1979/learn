/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.application;

import lombok.Data;

@Data
public class Person extends Party {
    protected String cbiCustName;
    protected String cbiCerType;//证件类型
    protected String cbiCerNo;//证件号码
    protected String cusTel;
    protected String cusEmail;

    protected Address address;

    protected String domicile;//户籍
    protected String resState;//居住房产状况
    protected String resYears;//居住年限
    protected String eduLevel;//教育水平

    protected String marryState;
    protected String spsName;
    protected String spsCerty;
    protected String spsCerNo;
    protected String spsMobileNo;

}
