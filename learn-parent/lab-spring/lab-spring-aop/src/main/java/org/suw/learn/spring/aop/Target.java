/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.spring.aop;

public class Target implements ITarget {

    public void doSomething() {
        System.out.println("doSomething()");
    }

    public void doA() {
        System.out.println("doA()");
    }

    public void otherThing() {
        System.out.println("otherThing()");
    }
}
