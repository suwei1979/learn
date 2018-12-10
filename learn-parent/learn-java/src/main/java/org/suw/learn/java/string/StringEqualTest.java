/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.java.string;

public class StringEqualTest {

    public static void main(String[] args) {

        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        System.out.println(s1 == s3.intern());
        System.out.print(s1 == s2.intern());
    }
}
