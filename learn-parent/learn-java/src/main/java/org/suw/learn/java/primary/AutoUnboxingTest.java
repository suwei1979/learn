/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.primary;

public class AutoUnboxingTest {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;  //自动装箱
        int c = 3;
        System.out.println(a == b);  //false, 非同一对象
        System.out.println(a == c);  //true, a自动拆箱成int类型再比较


    }
}
