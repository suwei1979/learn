/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.decorator;

/**
 * ConcreteDecoratorA
 *
 * @author suwei
 * @since 2019/12/17 : 5:40 PM
 **/
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component aComponent) {
        super(aComponent);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunctionA();
    }

    private void addedFunctionA() {
        System.out.println("调用具体构件装饰器A增加的额外功能：addedFunctionA()");
    }
}
