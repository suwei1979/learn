/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.mdm.model.event;

/**
 * 
 */
public abstract class Event {

    /**
     * Default constructor
     */
    public Event() {
    }

    /**
     * 
     */
    public Long eventId;

    /**
     * 
     */
    public String user;

    /**
     * 
     */
    public String srcSysId;

    /**
     * 
     */
    public String mdType;

}