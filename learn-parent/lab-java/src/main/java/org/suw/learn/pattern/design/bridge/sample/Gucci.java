/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.bridge.sample;

/**
 * Gucci
 *
 * @author suwei
 * @since 2019/12/16 : 4:00 PM
 **/
public class Gucci extends Bag {
    public Gucci() {
        this.brand = new Brand("GC");
    }
}
