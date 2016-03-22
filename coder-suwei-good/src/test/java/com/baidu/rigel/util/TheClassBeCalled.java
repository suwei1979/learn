/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.util;

import lombok.extern.slf4j.Slf4j;

/**
 * Test Class present the class be called.
 * 
 * @author suwei
 *
 */
@Slf4j
public class TheClassBeCalled {
    /**
     * default value of the field1
     */
    public static final String FIELD_DEFAULT = "defaultValue";

    /**
     * the caller path
     */
    private String callerPath;

    /**
     * test field to be get.
     */
    private String field1;

    /**
     * the caller method
     */
    private String callerMethod;

    /**
     * The Constructor
     */
    public TheClassBeCalled() {
        this.callerPath = "";
        this.field1 = FIELD_DEFAULT;
    }

    /**
     * Return the full qualified caller path for result assertions.
     * 
     * @return the callerPath
     */
    public String getCallerPath() {
        return callerPath;
    }

    /**
     * The test method to call private {@link TheClassBeCalled#methodC()}
     */
    public void methodB() {
        log.info("methodB");
        methodC();
    }

    /**
     * The method in which the {@link ReflectionUtils#getFullQualifiedCallerPath()} and
     * {@link ReflectionUtils#getCallerMethod()} will be called
     */
    private void methodC() {
        log.info("methodC");
        log.info("The caller path is :" + ReflectionUtils.getFullQualifiedCallerPath());
        callerPath = ReflectionUtils.getFullQualifiedCallerPath();
        callerMethod = ReflectionUtils.getCallerMethod();
    }

    /**
     * Getter for field1.
     * @return field1.
     */
    public String getField1() {
        return field1;
    }

    /**
     * Getter for callerMethod.
     * @return the caller method
     */
    public Object getCallerMethod() {
        return callerMethod;
    }
}
