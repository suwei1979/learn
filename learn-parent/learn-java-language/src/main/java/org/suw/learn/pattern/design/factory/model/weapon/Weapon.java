/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
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
