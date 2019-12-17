/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.bridge.define;

/**
 * Abstraction
 *
 * @author suwei
 * @since 2019/12/16 : 3:38 PM
 **/
public abstract class Abstraction {
    protected Implementor implementor;

    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}
