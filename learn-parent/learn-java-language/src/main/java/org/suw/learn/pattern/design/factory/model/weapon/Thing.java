/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.design.factory.model.weapon;

/**
 * 任何一种可被武器攻击的事务
 *
 * @author suwei
 */
public interface Thing {
    int getBlood();

    String getName();
}
