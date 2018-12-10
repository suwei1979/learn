/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
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
