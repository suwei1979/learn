/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.java8;

@FunctionalInterface
interface Converter<F, T> {
	T convert(F from);
}
