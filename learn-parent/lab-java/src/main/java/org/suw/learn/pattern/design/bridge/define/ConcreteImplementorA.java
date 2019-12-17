/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.bridge.define;

/**
 * ConcreteImplementorA
 *
 * @author suwei
 * @since 2019/12/16 : 3:39 PM
 **/
public class ConcreteImplementorA implements Implementor {

    @Override
    public void operation() {
        System.out.println("Concrete Implementor A");
    }
}
