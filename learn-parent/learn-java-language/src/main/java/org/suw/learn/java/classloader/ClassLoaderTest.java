/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.classloader;

/**
 * @classname: ClassLoaderTest
 * @author: suwei
 * @description:
 * @date: created in 2019/1/21 : 3:32 PM
 * @modified
 **/
public class ClassLoaderTest {
    public static void main(String args[]) {
        ClassLoader c =ClassLoaderTest.class.getClassLoader();
        System.out.println(c);

        ClassLoader c1 = c.getParent();
        System.out.println(c1);

        ClassLoader c2 = c1.getParent();
        System.out.println(c2);
    }
}
