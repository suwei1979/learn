/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.model.weapon;

/**
 * 武器类
 */
public interface Weapon {
    int getHurt();

    int getDuration();

    default void attack(Thing aThing) {
        System.out.println("Weapon.attack " + aThing.getName());
    }
}
