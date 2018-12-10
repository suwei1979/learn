/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.mdm.model.event;

import java.util.*;

/**
 * 
 * @author suwei
 *
 */
public class CommandEvent {

    /**
     * Default constructor
     */
    public CommandEvent() {
    }

    public CommandEventResult result;
    /**
     * 
     */
    public Set<EntityDTO> objects;

    /**
     * 
     */
    public Set<AssociationDTO> relationships;

}