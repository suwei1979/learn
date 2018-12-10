/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.java.grammer;

public class AssertionTest {
    private int a = 0;

    public AssertionTest(int a) {
        assert (a > 0);
        this.a = a;
    }
}
