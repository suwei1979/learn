/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.application;

import lombok.Data;

@Data
public class PartyType {
    //对Party的约束（若有），可以在此定义
    private String name;
    private String description;

}
