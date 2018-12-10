/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.java8;

import java.util.List;

import com.google.common.collect.Lists;

public class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter1 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }

    void testStream() {
        List<Integer> nums = Lists.newArrayList(1, null, 2, null, 3, 4, null, 6);
        nums.stream().filter(num -> num != null).count();

    }
}
