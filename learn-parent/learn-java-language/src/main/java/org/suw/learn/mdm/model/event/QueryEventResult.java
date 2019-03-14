/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
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