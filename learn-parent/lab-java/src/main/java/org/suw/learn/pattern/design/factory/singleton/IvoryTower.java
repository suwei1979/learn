/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.singleton;

public final class IvoryTower {
    private static final IvoryTower INSTANCE = new IvoryTower();

    /**
     *
     */
    private IvoryTower() {
    }

    public static IvoryTower getInstance() {
        return INSTANCE;
    }
}
