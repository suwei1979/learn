/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.bridge.define;

/**
 * ConcreteImplementorB
 *
 * @author suwei
 * @since 2019/12/16 : 3:40 PM
 **/
public class ConcreteImplementorB implements Implementor {

    @Override
    public void operation() {
        System.out.println("Concrete Implementor B");
    }
}
