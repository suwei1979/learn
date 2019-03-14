/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.mdm.model.event;

/**
 *
 */
public abstract class Event {

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

    /**
     * Default constructor
     */
    public Event() {
    }

}