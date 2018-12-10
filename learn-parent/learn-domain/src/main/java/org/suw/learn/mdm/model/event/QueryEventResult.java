/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.mdm.model.event;

import java.util.*;

/**
 * 
 */
public class QueryEventResult extends EventResult {

    /**
     * Default constructor
     */
    public QueryEventResult() {
    }

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

}