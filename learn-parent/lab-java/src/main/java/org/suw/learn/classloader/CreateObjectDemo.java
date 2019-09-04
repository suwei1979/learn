/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.classloader;

/**
 * CreateObjectDemo
 *
 * @author suwei
 * @since 2019/8/15 : 5:28 PM
 **/
public class CreateObjectDemo {
    public static void main(String args[]) {
//        ClassLoader classLoader;
        ClassLoader classLoader = CreateObjectDemo.class.getClassLoader();
        while (classLoader != null) {
            System.out.println("classLoader = " + classLoader);
            classLoader = classLoader.getParent();
        }

        Point originOne = new Point(0, 0 );

        Rectangle rectOne = new Rectangle(originOne);
        Rectangle rectTwo = new Rectangle(50, 100);

        rectOne.width = 100;
        rectOne.height = 50;

        System.out.println(rectOne);
        System.out.println(rectTwo);


    }
}
