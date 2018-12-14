/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.simple;

import java.util.function.Supplier;

import org.suw.learn.pattern.design.factory.model.weapon.Weapon;
import org.suw.learn.pattern.design.factory.model.weapon.WeaponType;

public interface Builder {
    void add(WeaponType name, Supplier<Weapon> supplier);

}
