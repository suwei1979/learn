/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.java.reflection;

import java.lang.reflect.Field;

public class ReflectionUtil {
    private ReflectionUtil() {
        throw new AssertionError();
    }

    public static Object getValue(Object target, String fieldName) {
        Class<?> clazz = target.getClass();
        String[] fs = fieldName.split("\\.");
        Object result = null;

        try {
            for (int i = 0; i < fs.length; i++) {
                Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                target = f.get(target);
                clazz = target.getClass();
            }

            Field f = clazz.getDeclaredField(fs[fs.length - 1]);
            f.setAccessible(true);
            result = f.get(target);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        }
        return result;
    }
}
