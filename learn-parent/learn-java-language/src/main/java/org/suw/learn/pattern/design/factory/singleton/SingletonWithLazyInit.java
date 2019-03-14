/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.singleton;

/**
 * 懒汉式，线程安全
 * 如果方法前不加锁，则需要考虑线程不安全问题
 */
public class SingletonWithLazyInit {
    private static SingletonWithLazyInit uniqueInstance;

    private SingletonWithLazyInit() {

    }

    public static synchronized SingletonWithLazyInit getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonWithLazyInit();
        }
        return uniqueInstance;
    }

}
