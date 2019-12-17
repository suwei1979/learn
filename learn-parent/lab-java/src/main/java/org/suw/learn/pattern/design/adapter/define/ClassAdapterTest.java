/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.adapter.define;

/**
 * ClassAdapterTest
 *
 * @author suwei
 * @since 2019/12/16 : 1:40 PM
 **/
public class ClassAdapterTest {

    public static void main(String... args) {
        System.out.println("类适配器模式测试");
        Target target = new ClassAdapter();
        target.request();
    }
}
