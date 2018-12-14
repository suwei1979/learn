/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.model.weapon;

import lombok.Data;

@Data
public class AbstractWeapon implements Weapon {
    private int duration;
    private int hurt;

}
