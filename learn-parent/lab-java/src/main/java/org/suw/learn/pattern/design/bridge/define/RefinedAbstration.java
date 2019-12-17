/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.bridge.define;

/**
 * RefinedAbstration
 *
 * @author suwei
 * @since 2019/12/16 : 3:40 PM
 **/
public class RefinedAbstration extends Abstraction {

    public RefinedAbstration(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        System.out.println("Refined Abstraction role is accessed!");
        implementor.operation();
    }
}
