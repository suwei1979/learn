/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Reflection工具类相关测试案例
 * 
 * @author suwei
 *
 */
public class ReflectionUtilsTest {
    // ClassA，调用方
    private CallerClass caller;
    // ClassB，被调用方,在classB的methodC中调用ReflectionUtils.getCallerPath方法
    private TheClassBeCalled classBeCalled;

    /**
     * init test data
     */
    @Before
    public void init() {
        classBeCalled = new TheClassBeCalled();
        caller = new CallerClass(classBeCalled);
    }

    /**
     * test case for {@link ReflectionUtils#getFullQualifiedCallerPath()}
     */
    @Test
    public void testGetCallerPath() {
        caller.methodA();
        assertEquals(classBeCalled.getCallerPath(), "com.baidu.rigel.util.CallerClass.methodA");
        classBeCalled.methodB();
        assertEquals(classBeCalled.getCallerPath(), "com.baidu.rigel.util.ReflectionUtilsTest.testGetCallerPath");
    }

    /**
     * test case for {@link ReflectionUtils#getCurrentMethod()}
     */
    @Test
    public void testGetCurrentMethod() {
        assertEquals(ReflectionUtils.getCurrentMethod(), "testGetCurrentMethod");
        caller.methodA();
        assertEquals(classBeCalled.getCallerPath(), caller.getClass().getName() + ".methodA");
    }

    /**
     * test case for {@link ReflectionUtils#getDeclaredFields(Object, Class)}
     */
    @Test
    public void testGetDeclaredFieldsOfType() {
        List<Field> fields = ReflectionUtils.getDeclaredFields(caller, TheClassBeCalled.class);
        assertTrue("获取CallerClass的Field列表为空", !fields.isEmpty());
        assertTrue("获取的类型不是TheClassBeCalled的子类",
                TheClassBeCalled.class.isAssignableFrom(fields.iterator().next().getType()));
    }

    /**
     * test case for {@link ReflectionUtils#getFieldValue(Object, Field)} and
     * {@link ReflectionUtils#setFieldValue(Object, Field, Object)}
     */
    @Test
    public void testSetAndGetFieldValue() throws Exception {
        // assertEqual(field)
        TheClassBeCalled anotherClassB = new TheClassBeCalled();
        List<Field> fields = ReflectionUtils.getDeclaredFields(caller, TheClassBeCalled.class);
        for (Field declaredField : fields) {
            assertEquals(classBeCalled, ReflectionUtils.getFieldValue(caller, declaredField));
            ReflectionUtils.setFieldValue(caller, declaredField, anotherClassB);
            assertEquals(anotherClassB, ReflectionUtils.getFieldValue(caller, declaredField));
        }
    }

    /**
     * Test Case for {@link ReflectionUtils#getCallerMethod()} and {@link ReflectionUtils#getFullQualifiedCallerPath()}
     */
    @Test
    public void testGetCallerMethod() {
        assertNull(classBeCalled.getCallerMethod());
        classBeCalled.methodB();
        assertEquals(classBeCalled.getCallerMethod(), "testGetCallerMethod");
    }

}
