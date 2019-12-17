/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.bridge.sample;

/**
 * LourisVuitton
 *
 * @author suwei
 * @since 2019/12/16 : 3:57 PM
 **/
public class LourisVuitton extends Bag {

    public LourisVuitton() {
        this.brand = new Brand("LV");
    }

}
