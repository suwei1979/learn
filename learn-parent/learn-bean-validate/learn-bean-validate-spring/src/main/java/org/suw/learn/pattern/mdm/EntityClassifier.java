/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.pattern.mdm;

import org.suw.learn.pattern.mdm.knowledgelevel.ClassifierEntityType;

import lombok.RequiredArgsConstructor;

/**
 * @author suwei
 *
 */
public class EntityClassifier extends Entity<ClassifierEntityType>{
    final private EntityBase baseInfo;
    /**
     * @param name
     */
    public EntityClassifier(String name, ClassifierEntityType type, EntityBase baseInfo) {
        super(name, type);
        this.baseInfo = baseInfo;
//        baseInfo = new EntityBase(type.getBaseInfo().getName(), type.getBaseInfo());
    }

}
