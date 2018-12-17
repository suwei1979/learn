/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;

/**
 * Created by zion on 5/6/15.
 */
public class AspectUtils {
    private AspectUtils() {
    }

    public static <T extends Annotation> T getAnnotation(final JoinPoint joinPoint, final Class<T> annotationClass) {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return methodSignature.getMethod().getAnnotation(annotationClass);
    }
}
