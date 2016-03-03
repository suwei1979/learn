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
    private ClassA classA;
    // ClassB，被调用方,在classB的methodC中调用ReflectionUtils.getCallerPath方法
    private ClassB classB;

    /**
     * 初始化测试数据
     */
    @Before
    public void init() {
        classB = new ClassB();
        classA = new ClassA(classB);
    }

    @Test
    public void testGetCallerPath() {
        classA.methodA();
        assertEquals(classB.getCallerPath(), "com.baidu.rigel.util.ClassA.methodA");
        classB.methodB();
        assertEquals(classB.getCallerPath(), "com.baidu.rigel.util.ReflectionUtilsTest.testGetCallerPath");
    }

    @Test
    public void testGetCurrentMethod() {
        assertEquals(ReflectionUtils.getCurrentMethod(), "testGetCurrentMethod");
        classA.methodA();
        assertEquals(classB.getCallerPath(), classA.getClass().getName() + ".methodA");
    }

    @Test
    public void testGetDeclaredFieldsOfType() {
        List<Field> fields = ReflectionUtils.getDeclaredFields(classA, ClassB.class);
        assertTrue("获取ClassA的Field列表为空", !fields.isEmpty());
        assertTrue("获取的类型不是ClassB的子类", ClassB.class.isAssignableFrom(fields.iterator().next().getType()));
    }
    
    @Test
    public void testSetAndGetFieldValue() throws Exception {
//        assertEqual(field)
        ClassB anotherClassB = new ClassB();
        List<Field> fields = ReflectionUtils.getDeclaredFields(classA, ClassB.class);
        for (Field declaredField : fields) {
            assertEquals(classB, ReflectionUtils.getFieldValue(classA, declaredField));
            ReflectionUtils.setFieldValue(classA, declaredField, anotherClassB);
            assertEquals(anotherClassB, ReflectionUtils.getFieldValue(classA, declaredField));
        }
    }
    
    @Test
    public void testGetCallerMethod() {
        assertNull(classB.getCallerMethod());
        classB.methodB();
        assertEquals(classB.getCallerMethod(), "testGetCallerMethod");
    }
    
}
