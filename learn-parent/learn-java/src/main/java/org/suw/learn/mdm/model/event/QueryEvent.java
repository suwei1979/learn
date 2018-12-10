/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.mdm.model.event;

import java.util.Set;

/**
 *
 */
public class QueryEvent {

    /**
     *
     */
    public boolean cascade;
    /**
     *
     */
    public String resultType;
    /**
     *
     */
    public Set<Condition> conditions;

    /**
     * Default constructor
     */
    public QueryEvent() {
    }
}