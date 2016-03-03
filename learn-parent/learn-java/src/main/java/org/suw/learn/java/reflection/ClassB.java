/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.reflection;

/**
 * @author suwei
 *
 */
public class ClassB {
    public static final String FIELD_DEFAULT = "defaultValue";
    private String callerPath;
    private String field1;
    private String callerMethod;

    public ClassB() {
        this.callerPath = "";
        this.field1 = FIELD_DEFAULT;
    }
    /**
     * 返回调用方全路径，供测试结果断言用
     * @return the callerPath
     */
    public String getCallerPath() {
        return callerPath;
    }

    /**
     * 
     */
    public void methodB() {
        System.out.println("methodB");
        methodC();
    }

    /**
     * 
     */
    private void methodC() {
        System.out.println("methodC");
//        System.out.println("The caller path is :" + ReflectionUtils.getFullQualifiedCallerPath());
//        callerPath = ReflectionUtils.getFullQualifiedCallerPath();
//        callerMethod = ReflectionUtils.getCallerMethod();
    }

    public String getField1() {
        return field1;
    }
    /**
     * @return
     */
    public Object getCallerMethod() {
        return callerMethod;
    }
}
