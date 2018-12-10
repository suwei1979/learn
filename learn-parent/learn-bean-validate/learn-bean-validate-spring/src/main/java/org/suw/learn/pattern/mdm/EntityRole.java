/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.pattern.mdm;

import org.suw.learn.pattern.mdm.knowledgelevel.RoleOrientedEntityType;

/**
 * @author suwei
 *
 */
public class EntityRole extends Entity<RoleOrientedEntityType>{

    /**
     * @param name
     */
    public EntityRole(String name, RoleOrientedEntityType type, EntityBase baseInfo) {
        super(name, type);
        // TODO Auto-generated constructor stub
    }

}
