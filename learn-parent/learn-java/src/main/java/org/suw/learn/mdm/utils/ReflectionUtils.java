/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.mdm.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.UndeclaredThrowableException;

import lombok.extern.slf4j.Slf4j;

/**
 * Reflection Utilities
 *
 * @author suwei
 */
@Slf4j
public class ReflectionUtils {

    /**
     * Find the annotation on the class of object
     *
     * @param object         the object that was annotated by the annotationType
     * @param annotationType the annotation type to be find
     *
     * @return the corresponding annotation type, null if the given annotation type is not present
     */
    public static <A extends Annotation> A getAnnotation(Object object, Class<A> annotationType) {
        Assert.notNull(object);
        Assert.notNull(annotationType);

        Class<?> annotatedClass = object.getClass();
        return getAnnotation(annotatedClass, annotationType);
    }

    /**
     * Find the annotation on the class
     *
     * @param annotatedClass
     * @param annotationType
     *
     * @return
     */
    public static <A extends Annotation> A getAnnotation(Class<?> annotatedClass, Class<A> annotationType) {
        if (annotatedClass.isAnnotationPresent(annotationType)) {
            return annotatedClass.getAnnotation(annotationType);
        } else {
            return null;
        }
    }

    /**
     * Find the field that is annotated by the corresponding annotationClass
     *
     * @param clazz          the class that is annotated by
     * @param annotationType the annotation class that annotated on the field
     *
     * @return the field that is annotated by the annotation type
     */
    public static Field findField(Class<?> clazz, Class<? extends Annotation> annotationType) {
        for (Field field : clazz.getFields()) {
            if (field.isAnnotationPresent(annotationType)) {
                return field;
            }
        }
        return null;
    }

    /**
     * Get the field represented by the supplied {@link Field field object} on the specified {@link Object target
     * object}. In accordance with {@link Field#get(Object)} semantics, the returned value is automatically wrapped if
     * the underlying field has a corresponding type of fieldValueType.
     * <p>
     * Thrown exceptions are handled via a call to {@link #handleReflectionException(Exception)}.
     * {@link IllegalArgumentException } is raised when the field value can not been cast to fiedValueType
     *
     * @param object
     * @param annotationClass
     * @param fieldValueType
     *
     * @return the field's current value of the field value type
     */
    public static <T> T getField(Object object, Class<? extends Annotation> annotationClass, Class<T> fieldValueType) {
        Assert.notNull(object);
        Field annotatedField = findField(object.getClass(), annotationClass);
        Assert.notNull(annotatedField,
                String.format("Can't find the field annotated with %s", annotationClass.getName()));
        ReflectionUtils.makeAccessible(annotatedField);
        Object fieldValue = getField(annotatedField, object);
        if (fieldValueType.isAssignableFrom(fieldValue.getClass())) {
            return fieldValueType.cast(fieldValue);
        } else {
            String errorMsg = String.format("The expected field type %s is not assignable from the input object %s",
                    fieldValueType.getName(), object.getClass().getName());
            log.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);

        }
    }

    /**
     * find the field that annotated by the annotationClass, and return the field value.
     *
     * @param target          The target object
     * @param annotationClass The annotation
     *
     * @return filed value
     */
    public static Object getField(Object target, Class<? extends Annotation> annotationClass) {
        Field field = findField(target.getClass(), annotationClass);
        return getField(field, target);
    }

    /**
     * Get the field represented by the supplied {@link Field field object} on the specified {@link Object target
     * object}. In accordance with {@link Field#get(Object)} semantics, the returned value is automatically wrapped if
     * the underlying field has a primitive type.
     * <p>
     * Thrown exceptions are handled via a call to {@link #handleReflectionException(Exception)}.
     *
     * @param field  the field to get
     * @param target the target object from which to get the field
     *
     * @return the field's current value
     */
    public static Object getField(Field field, Object target) {
        Assert.notNull(field);
        Assert.notNull(target);
        try {
            return field.get(target);
        } catch (IllegalAccessException ex) {
            handleReflectionException(ex);
            String errorMsg = "Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage();
            log.error(errorMsg);
            throw new IllegalStateException(errorMsg);
        }

    }

    /**
     * 获取目标对象上的field值，其返回类型为指定的fieldValueType
     *
     * @param fieldName      名称
     * @param target         目标对象
     * @param fieldValueType 预期的Filed类型
     *
     * @return fieldValue which type is fieldValueType, an exception will raised if the fieldValueType<br>
     * and the exact field type are mismatched.
     */
    public static <F> F getField(String fieldName, Object target, Class<F> fieldValueType) {
        Assert.notNull(fieldName);
        Assert.notNull(target);
        Assert.notNull(fieldValueType);
        Field field = null;
        try {
            field = target.getClass().getField(fieldName);
        } catch (NoSuchFieldException | SecurityException e) {
            handleReflectionException(e);
        }
        Object fieldValue = getField(field, target);
        if (fieldValueType.isAssignableFrom(fieldValue.getClass())) {
            return fieldValueType.cast(fieldValue);
        } else {
            String errorMsg = String.format(
                    "The expected field value type %s is not assignable from the exact field value type %s",
                    fieldValueType.getName(), fieldValue.getClass().getName());
            log.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }

    }

    /**
     * Handle the given reflection exception. Should only be called if no checked exception is expected to be thrown by
     * the target provider.
     * <p>
     * Throws the underlying RuntimeException or Error in case of an InvocationTargetException with such a root cause.
     * Throws an IllegalStateException with an appropriate message else.
     *
     * @param ex the reflection exception to handle
     */
    public static void handleReflectionException(Exception ex) {
        String errorMsg;
        if (ex instanceof NoSuchMethodException) {
            errorMsg = "Method not found: " + ex.getMessage();
            log.error(errorMsg);
            throw new IllegalStateException(errorMsg);
        }
        if (ex instanceof IllegalAccessException) {
            errorMsg = "Could not access provider: " + ex.getMessage();
            log.error(errorMsg);
            throw new IllegalStateException(errorMsg);
        }
        if (ex instanceof InvocationTargetException) {
            handleInvocationTargetException((InvocationTargetException) ex);
        }
        if (ex instanceof RuntimeException) {
            log.error(ex.getMessage());
            throw (RuntimeException) ex;
        }
        // if (ex instanceof ClassCastException) {
        // log.error(ex.getMessage());
        // throw (RuntimeException)ex;
        // }
        log.error(ex.getMessage());
        throw new UndeclaredThrowableException(ex);
    }

    /**
     * Handle the given invocation target exception. Should only be called if no checked exception is expected to be
     * thrown by the target provider.
     * <p>
     * Throws the underlying RuntimeException or Error in case of such a root cause. Throws an IllegalStateException
     * else.
     *
     * @param ex the invocation target exception to handle
     */
    public static void handleInvocationTargetException(InvocationTargetException ex) {
        rethrowRuntimeException(ex.getTargetException());
    }

    /**
     * Rethrow the given {@link Throwable exception}, which is presumably the <em>target exception</em> of an
     * {@link InvocationTargetException}. Should only be called if no checked exception is expected to be thrown by the
     * target provider.
     * <p>
     * Rethrows the underlying exception cast to an {@link RuntimeException} or {@link Error} if appropriate; otherwise,
     * throws an {@link IllegalStateException}.
     *
     * @param ex the exception to rethrow
     *
     * @throws RuntimeException the rethrown exception
     */
    public static void rethrowRuntimeException(Throwable ex) {
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        }
        if (ex instanceof Error) {
            throw (Error) ex;
        }
        throw new UndeclaredThrowableException(ex);
    }

    /**
     * Make the given field accessible, explicitly setting it accessible if necessary. The {@code setAccessible(true)}
     * provider is only called when actually necessary, to avoid unnecessary conflicts with a JVM SecurityManager (if
     * active).
     *
     * @param field the field to make accessible
     *
     * @see java.lang.reflect.Field#setAccessible
     */
    public static void makeAccessible(Field field) {
        if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())
                     || Modifier.isFinal(field.getModifiers())) && !field.isAccessible()) {
            field.setAccessible(true);
        }

    }

    /**
     * @param objToCast object to be casted
     * @param target    The class cast to
     *
     * @return
     */
    public static <T> T cast(Object objToCast, Class<T> target) {
        Assert.notNull(objToCast);
        if (target.isAssignableFrom(objToCast.getClass())) {
            return target.cast(objToCast);
        } else {
            String errMsg = String.format("Can't cast from $s to $s", objToCast.getClass(), target);
            log.error(errMsg);
            throw new IllegalArgumentException(errMsg);
        }
    }

}
