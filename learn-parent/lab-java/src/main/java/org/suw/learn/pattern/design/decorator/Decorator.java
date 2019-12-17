/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.decorator;

/**
 * Decorator
 *
 * @author suwei
 * @since 2019/12/17 : 5:38 PM
 **/
public abstract class Decorator implements Component {
    private Component aComponent;

    protected Decorator(Component aComponent) {
        this.aComponent = aComponent;
    }

    @Override
    public void operation() {
        aComponent.operation();
    }
}
