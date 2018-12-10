/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.mdm.model.event;

import java.util.Set;

/**
 *
 */
public class QueryEventResult extends EventResult {

    /**
     *
     */
    public int numOfResults;
    /**
     *
     */
    public Set<AssociationDTO> relationships;
    /**
     *
     */
    public EntityDTO object;

    /**
     * Default constructor
     */
    public QueryEventResult() {
    }

}