/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.okta.beer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @classname: Beer
 * @author: suwei
 * @description:
 * @date: created in 2018/12/21 : 5:49 PM
 * @modified
 **/
@Entity
@Data
@AllArgsConstructor
public class Beer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Beer(String name) {
        this.name = name;
    }

    private Beer() {
    }
}
