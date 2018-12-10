/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.mdm.model.event;

import java.util.Set;

/**
 * @author suwei
 */
public class CommandEvent {

    public CommandEventResult result;
    /**
     *
     */
    public Set<EntityDTO> objects;
    /**
     *
     */
    public Set<AssociationDTO> relationships;

    /**
     * Default constructor
     */
    public CommandEvent() {
    }

}