/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.decorator;

/**
 * ConcreteDecoratorB
 *
 * @author suwei
 * @since 2019/12/17 : 5:43 PM
 **/
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component aComponent) {
        super(aComponent);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunctionB();
    }

    private void addedFunctionB() {
        System.out.println("调用具体构件装饰器A增加的额外功能：addedFunctionA()");
    }
}
