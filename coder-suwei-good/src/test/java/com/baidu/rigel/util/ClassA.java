/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.util;

/**
 * @author suwei
 *
 */
public class ClassA {
    private ClassB classB;
    
    public ClassA(ClassB classB) {
        this.classB = classB;
    }
    public void methodA() {
        System.out.println("methodA");
        classB.methodB();
    }
}
