/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.util;

import lombok.extern.slf4j.Slf4j;

/**
 * Test Class that represent a Caller<br>
 * 
 * @author suwei
 *
 */
@Slf4j
public class CallerClass {
    /**
     * Class be called
     */
    private TheClassBeCalled classBeCalled;

    /**
     * Constructor
     * @param classBeCalled
     */
    public CallerClass(TheClassBeCalled classBeCalled) {
        this.classBeCalled = classBeCalled;
    }

    /**
     * Test Method mock the caller.
     */
    public void methodA() {
        log.info("methodA");
        classBeCalled.methodB();
    }
}
