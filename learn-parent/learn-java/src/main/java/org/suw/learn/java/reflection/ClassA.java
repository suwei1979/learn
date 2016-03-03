/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.reflection;

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
