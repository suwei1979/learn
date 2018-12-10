/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.mdm.model.event;

import java.util.*;

/**
 * 
 */
public class EntityDTO {

    /**
     * Default constructor
     */
    public EntityDTO(long objectId) {
        this.objectId = objectId;
    }

    public long getObjectId() {
        return objectId;
    }

    /**
     * 
     */
    public long objectId;

    public Map<String, String> values;
    /**
     * 
     */
    public Set<EntityDTO> aggregateObjects;
}