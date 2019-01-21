/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.boot.angular.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * @classname: Beer
 * @author: suwei
 * @description:
 * @date: created in 2018/12/31 : 6:33 PM
 * @modified
 **/
@Data
@Entity
public class Beer {

    @Id
    @GeneratedValue
    private Long id;


    private String name;

    public Beer() {
    }

    public Beer(String name) {
        this.name = name;
    }

    public static void main(String... args) {
        Beer beer = new Beer("Burdwiser");
        beer.setId(1L);

        System.out.println("beer = " + beer);
    }
}
