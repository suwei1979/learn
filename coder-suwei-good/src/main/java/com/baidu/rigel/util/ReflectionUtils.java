/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author suwei
 *
 */
@Slf4j
public class ReflectionUtils {
    /**
     * 获取当前类调用方的全路径（className.methodName）
     *
     * @return 调用方代码行所在的类名+方法名
     */
    public static String getFullQualifiedCallerPath() {
        String result = null;
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();

        // 调用堆栈顶部的两个元素将始终如下：
        // 1. java.lang.Thread:getStackTrace
        // 2. com.baidu.rigel.util.ReflectionUtils:getFullQualifiedCallerPath

        // callee：调用本方法的类
        String callee = callStack[2].getClassName();
        log.debug("获取调用" + callee + "." + callStack[2].getMethodName() + "方法的外部调用方");
        // caller，调用callee的类
        String callerClazzName = null;
        String callerMethodName = null;
        for (int i = 2; i < callStack.length; i++) {
            StackTraceElement element = callStack[i];
            // 在调用堆栈中查找到第一个直接调用方后返回
            log.debug("调用堆栈[" + i + "] - " + element.getClassName() + "." + element.getMethodName());
            if (element.getClassName().equals(callee) || element.getClassName().startsWith("com.sun.proxy.$")) {
                continue;
            } else {
                callerClazzName = element.getClassName();
                callerMethodName = element.getMethodName();
                result = callerClazzName + "." + callerMethodName;
                break;
            }
        }
        log.debug("调用方全路径名为：" + result);
        return result;
    }

    /**
     * 获取当前类外部调用方的方法名
     *
     * @return 调用方代码行所在方法的名成
     */
    public static String getCallerMethod() {
        String result = null;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String callee = stackTrace[2].getClassName();
        log.debug("获取调用" + callee + "." + stackTrace[2].getMethodName() + "方法的外部调用方");
        for (int i = 2; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            log.debug("调用堆栈[" + i + "] - " + element.getClassName() + "." + element.getMethodName());
            if (element.getClassName().equals(callee) || element.getClassName().startsWith("com.sun.proxy.$")) {
                continue;
            } else {
                result = element.getMethodName();
                log.debug("外部调用方：" + element.getClassName() + "." + result);
                break;
            }

        }
        return result;
    }

    /**
     * 在方法中调用本方法，将返回当前执行的方法名
     *
     * @return 调用本方法代码所在的方法名
     */
    public static String getCurrentMethod() {
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        String result = callStack[2].getMethodName();
        return result;
    }

    /**
     * 返回指定对象上的，类型为{@code expectType} 或{@code expectType子类}的Field
     *
     * @param object 指定的对象
     * @param fieldType 预期的Field类型
     * @return
     */
    public static List<Field> getDeclaredFields(Object object, Class<?> fieldType) {
        List<Field> result = new ArrayList<Field>();
        Field[] allFields = object.getClass().getDeclaredFields();
        for (Field field : allFields) {
            if (fieldType.isAssignableFrom(field.getType())) {
                result.add(field);
            }
        }
        return result;
    }

    /**
     * 设置Field的值
     *
     * @param bean 声明了field的对象
     * @param field 指定的Field
     * @param value 值，必须是声明的Field类型的子类
     */
    public static void setFieldValue(Object bean, Field field, Object value) {
        Asserts.notNull(bean);
        Asserts.notNull(field);
        Asserts.notNull(value);
        Asserts.isTrue(field.getType().isAssignableFrom(value.getClass()));

        boolean accessible = field.isAccessible();
        field.setAccessible(true);
        try {
            field.set(bean, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            field.setAccessible(accessible);
        }
    }

    /**
     * 获取对象{@code bean}的Filed值
     *
     * @param bean
     * @param field
     * @return field value of bean
     */
    public static Object getFieldValue(Object bean, Field field) {
        Object result;

        boolean accessible = field.isAccessible();
        field.setAccessible(true);
        try {
            result = field.get(bean);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        field.setAccessible(accessible);

        return result;
    }

    /**
     * 获取在声明Filed时所绑定的泛型参数类型，其位置由index指定
     *
     * @param field
     * @param index
     * @return 处于index所指定位置的泛型参数的实际类型
     */
    public static Class<?> getBindingGenericType(Field field, int index) {
        ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
        Asserts.isTrue(index < parameterizedType.getActualTypeArguments().length);
        return (Class<?>) parameterizedType.getActualTypeArguments()[index];
    }
}
