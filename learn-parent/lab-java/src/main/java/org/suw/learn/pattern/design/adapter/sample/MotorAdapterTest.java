/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.adapter.sample;

import org.suw.learn.pattern.design.ReadXML;

/**
 * MotorAdapterTest
 *
 * @author suwei
 * @since 2019/12/16 : 3:13 PM
 **/
public class MotorAdapterTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        System.out.println("适配器模式测试：");
        Motor motor = ReadXML.getObject(Motor.class, "className");
        motor.drive();
    }

}
