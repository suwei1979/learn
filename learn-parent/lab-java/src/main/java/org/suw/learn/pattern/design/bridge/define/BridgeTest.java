/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.bridge.define;

/**
 * BridgeTest
 *
 * @author suwei
 * @since 2019/12/16 : 3:42 PM
 **/
public class BridgeTest {
    public static void main(String... args) {
        Implementor implementor = new ConcreteImplementorA();
        Abstraction abstraction = new RefinedAbstration(implementor);
        abstraction.operation();
    }

}
