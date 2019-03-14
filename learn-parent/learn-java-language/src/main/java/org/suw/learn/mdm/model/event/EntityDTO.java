/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.mdm.model.event;

import java.util.Map;
import java.util.Set;

/**
 *
 */
public class EntityDTO {

    /**
     *
     */
    public long objectId;
    public Map<String, String> values;
    /**
     *
     */
    public Set<EntityDTO> aggregateObjects;

    /**
     * Default constructor
     */
    public EntityDTO(long objectId) {
        this.objectId = objectId;
    }

    public long getObjectId() {
        return objectId;
    }
}