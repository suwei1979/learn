/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.java8;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
