/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory;

import org.junit.jupiter.api.BeforeEach;
import org.suw.learn.pattern.design.factory.model.Axe;
import org.suw.learn.pattern.design.factory.model.Bow;
import org.suw.learn.pattern.design.factory.model.Spear;
import org.suw.learn.pattern.design.factory.model.Sword;
import org.suw.learn.pattern.design.factory.model.WeaponType;

public class WeaponFactoryTest {
    private WeaponFactory factory;

    @BeforeEach
    public void init() {
        factory = WeaponFactory.factory(builder -> {
            builder.add(WeaponType.AXE, Axe::new);
            builder.add(WeaponType.BOW, Bow::new);
            builder.add(WeaponType.SPEAR, Spear::new);
            builder.add(WeaponType.SWORD, Sword::new);
        });
    }
}
