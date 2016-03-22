/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository.mybatis;

import lombok.Data;

/**
 * Account，The test domain object.
 * 
 * @author suwei
 *
 */
@Data
public class Account {
    /**
     * The account id.
     */
    Long id;
    
    /**
     * The account name.
     */
    String name;
}
