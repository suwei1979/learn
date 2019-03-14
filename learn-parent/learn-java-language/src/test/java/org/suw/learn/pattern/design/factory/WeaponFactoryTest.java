/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.suw.learn.pattern.design.factory.model.weapon.Axe;
import org.suw.learn.pattern.design.factory.model.weapon.Bow;
import org.suw.learn.pattern.design.factory.model.weapon.Spear;
import org.suw.learn.pattern.design.factory.model.weapon.Sword;
import org.suw.learn.pattern.design.factory.model.weapon.Weapon;
import org.suw.learn.pattern.design.factory.model.weapon.WeaponType;
import org.suw.learn.pattern.design.factory.simple.WeaponFactory;

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

    @Test
    public void testSpearWeapon() {
        Weapon spear = factory.create(WeaponType.SPEAR);
        verifyWeapon(spear, Spear.class);
    }

    @Test
    public void testAxeWeapon() {
        Weapon axe = factory.create(WeaponType.AXE);
        verifyWeapon(axe, Axe.class);
    }

    @Test
    public void testBowWeapon() {
        Weapon aBow = factory.create(WeaponType.BOW);
        verifyWeapon(aBow, Bow.class);
    }

    @Test
    public void testSwordWeapon() {
        Weapon sword = factory.create(WeaponType.SWORD);
        verifyWeapon(sword, Sword.class);
    }

    private void verifyWeapon(Weapon weapon, Class<?> weaponClass) {
        assertTrue(weaponClass.isInstance(weapon));
    }
}
