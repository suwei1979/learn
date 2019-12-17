/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.adapter.sample;

/**
 * ElectricMotorAdapter
 *
 * @author suwei
 * @since 2019/12/16 : 3:09 PM
 **/
public class ElectricMotorAdapter implements Motor {

    ElectricMotor eMotor;
    public ElectricMotorAdapter() {
        eMotor = new ElectricMotor();
    }

    @Override
    public void drive() {
        eMotor.electricDrive();
    }
}
