/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.adapter.define;

/**
 * ObjectAdapterTest
 *
 * @author suwei
 * @since 2019/12/16 : 1:46 PM
 **/
public class ObjectAdapterTest {



    public static void main(String... args) {
        System.out.println("对象适配器测试");
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();

    }

}
