/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
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