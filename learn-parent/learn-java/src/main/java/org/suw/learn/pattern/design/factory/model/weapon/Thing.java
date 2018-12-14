/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
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
