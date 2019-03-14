/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.model.weapon;

import lombok.Data;

@Data
public class AbstractWeapon implements Weapon {
    private int duration;
    private int hurt;

}
