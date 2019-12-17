/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.decorator;

/**
 * DecoratorTest
 *
 * @author suwei
 * @since 2019/12/17 : 5:57 PM
 **/
public class DecoratorTest {

    public static void main(String... args) {
        Component aComponent = new ConcreteComponent();
        Decorator decoratorA = new ConcreteDecoratorA(aComponent);
        Decorator decoratorB = new ConcreteDecoratorB(aComponent);

        decoratorA.operation();
        decoratorB.operation();

    }

}
