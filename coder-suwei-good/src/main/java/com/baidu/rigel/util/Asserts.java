/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.util;

import lombok.extern.slf4j.Slf4j;

/**
 * Assert Utilities
 *
 * @author suwei
 *
 */
@Slf4j
public class Asserts {

    /**
     * Assert that an object is not {@code null} .
     *
     * <pre class="code">
     * Assert.notNull(clazz);
     * </pre>
     *
     * @param object the object to check
     * @throws IllegalArgumentException if the object is {@code null}
     */
    public static void notNull(Object object) {
        notNull(object, "This argument is required, can't be null");
    }

    /**
     * Assert that an object is not {@code null} .
     *
     * <pre class="code">
     * Assert.notNull(clazz, "The class must not be null");
     * </pre>
     *
     * @param object the object to check
     * @param messageKey the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the object is {@code null}
     */
    public static void notNull(Object object, String defaultMessage) {
        if (null == object) {
            // log.error(messageKey);
            log.error(defaultMessage);
            throw new IllegalArgumentException(defaultMessage);
        }
    }

    /**
     * Assert that an arrays length must be the expected value.
     * 
     * @param stringArray the given array
     * @param lengthExpected the expected length of the given array.
     */
    public static void arrayLength(String[] stringArray, int lengthExpected) {
        notNull(stringArray);
        if (stringArray.length != lengthExpected) {
            String errorMsg = String.format("The array length must be %d", lengthExpected);
            log.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    /**
     * Assert a boolean expression, throwing {@code IllegalArgumentException} if the test result is {@code false}.
     *
     * <pre class="code">
     * Assert.isTrue(i &gt; 0, "The value must be greater than zero");
     * </pre>
     *
     * @param expression a boolean expression
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            log.error(message);
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert a boolean expression, throwing {@code IllegalArgumentException} if the test result is {@code false}.
     *
     * <pre class="code">
     * Assert.isTrue(i &gt; 0);
     * </pre>
     *
     * @param expression a boolean expression
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }
}
