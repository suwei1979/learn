/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.grammer;

public class AssertionTest {
    private int a = 0;

    public AssertionTest(int a) {
        assert (a > 0);
        this.a = a;
    }
}
