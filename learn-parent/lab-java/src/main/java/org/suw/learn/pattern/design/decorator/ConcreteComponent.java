/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.decorator;

/**
 * ConcreteComponent
 *
 * @author suwei
 * @since 2019/12/17 : 5:26 PM
 **/
public class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("调用具体组建的方法：operation");
    }
}
