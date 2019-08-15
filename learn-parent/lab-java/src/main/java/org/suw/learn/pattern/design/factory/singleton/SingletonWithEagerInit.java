/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.singleton;

public class SingletonWithEagerInit {
    private static SingletonWithEagerInit uniqueInstance;

    private SingletonWithEagerInit() {

    }

    public static SingletonWithEagerInit getUniqueInstance() {
        return uniqueInstance;
    }
}
