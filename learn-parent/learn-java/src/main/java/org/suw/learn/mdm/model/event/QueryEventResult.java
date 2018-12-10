/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
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