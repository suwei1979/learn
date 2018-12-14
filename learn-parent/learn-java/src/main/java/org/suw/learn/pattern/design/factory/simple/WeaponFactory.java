/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.suw.learn.pattern.design.factory.model.weapon.Weapon;
import org.suw.learn.pattern.design.factory.model.weapon.WeaponType;

public interface WeaponFactory {
    static WeaponFactory factory(Consumer<Builder> consumer) {
        Map<WeaponType, Supplier<Weapon>> map = new HashMap<>();
        consumer.accept(map::put);
        return name -> map.get(name).get();

    }

    public Weapon create(WeaponType name);
}
