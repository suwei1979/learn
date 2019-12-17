/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.adapter.sample;

/**
 * OpticalMotorAdapter
 *
 * @author suwei
 * @since 2019/12/16 : 3:11 PM
 **/
public class OpticalMotorAdapter implements Motor {

    OpticalMotor opticalMotor;

    public OpticalMotorAdapter() {
        this.opticalMotor = new OpticalMotor();
    }

    @Override
    public void drive() {
        opticalMotor.opticalDrive();
    }
}
