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
 * The reflection utilities.
 * 
 * @author suwei
 *
 */
@Slf4j
public class ReflectionUtils {
    /**
     * 
     * Gets the full path of external object's method that calls the current method （className.methodName）
     *
     * @return the full path of the external object's method.
     */
    public static String getFullQualifiedCallerPath() {
        String result = null;
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();

        // The top two elements in the call stack will always be as follows:
        // 1. java.lang.Thread:getStackTrace
        // 2. com.baidu.rigel.util.ReflectionUtils:getFullQualifiedCallerPath

        // callee：the class that call the ReflectrionUtils.getFullQualifiedCallerPath()
        String callee = callStack[2].getClassName();
        log.debug("获取调用" + callee + "." + callStack[2].getMethodName() + "方法的外部调用方");
        // caller，the called of the callee
        String callerClazzName = null;
        String callerMethodName = null;
        for (int i = 2; i < callStack.length; i++) {
            StackTraceElement element = callStack[i];
            log.debug("调用堆栈[" + i + "] - " + element.getClassName() + "." + element.getMethodName());
            if (!element.getClassName().equals(callee) && !element.getClassName().startsWith("com.sun.proxy.$")) {
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
     * Gets external method name that called the current method
     *
     * @return the external method name.
     */
    public static String getCallerMethod() {
        String result = null;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String callee = stackTrace[2].getClassName();
        log.debug("获取调用" + callee + "." + stackTrace[2].getMethodName() + "方法的外部调用方");
        for (int i = 2; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            log.debug("调用堆栈[" + i + "] - " + element.getClassName() + "." + element.getMethodName());
            if (!element.getClassName().equals(callee) && !element.getClassName().startsWith("com.sun.proxy.$")) {
                result = element.getMethodName();
                log.debug("外部调用方：" + element.getClassName() + "." + result);
                break;
            }

        }
        return result;
    }

    /**
     * Return the method name which call the ReflectionUtils.getCurrentMethod().
     *
     * @return The method name of the line of code exists.
     */
    public static String getCurrentMethod() {
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        String result = callStack[2].getMethodName();
        return result;
    }

    /**
     * Returns the Field of the specified object，which type is {@code expectType} or the sub-type of the
     * {@code expectType}
     *
     * @param object the given object.
     * @param fieldType the expected field type.
     * @return the relevant field list or empty list if none found.
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
     * 设置Field的值 Set the value to the given field of the bean.
     *
     * @param bean the given java bean.
     * @param field the field to be set.
     * @param value the value of the field.
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
     * Get the field value of the given {@code bean}
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
            log.error("Error occured when try to get field [" + field.getName() + "] value from bean ["
                    + bean.getClass().getSimpleName() + "]");
            throw new RuntimeException(e);
        } finally {
            field.setAccessible(accessible);
        }

        return result;
    }

    /**
     * Gets the generic parameter type that is bound to the Filed when it is declared, and whose location is specified
     * by the index.<br>
     * <b>example: <b><br>
     * for given bean which have declared an field named foo, which type is Foo<GType1,GType2>, and the
     * {@code getBindingGenericType(fooField, 0)} will return GType1.
     * 
     * @param field
     * @param index
     * @return The actual type of generic parameters at the location specified by index.
     */
    public static Class<?> getBindingGenericType(Field field, int index) {
        ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
        Asserts.isTrue(index < parameterizedType.getActualTypeArguments().length);
        return (Class<?>) parameterizedType.getActualTypeArguments()[index];
    }
}
