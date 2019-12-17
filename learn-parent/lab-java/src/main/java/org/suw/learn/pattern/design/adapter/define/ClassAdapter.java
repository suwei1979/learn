/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.adapter.define;

/**
 * ClassAdapter
 *
 * @author suwei
 * @since 2019/12/16 : 1:41 PM
 **/
public class ClassAdapter extends Adaptee implements Target {


    @Override
    public void request() {
        specificRequest();
    }
}
