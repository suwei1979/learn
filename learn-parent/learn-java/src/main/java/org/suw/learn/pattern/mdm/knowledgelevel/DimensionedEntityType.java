/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.mdm.knowledgelevel;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author suwei
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class DimensionedEntityType extends EntityType {
    private String dimension;
    
    @ManyToOne
    private BaseEntityType baseInfo;
    /**
     * @param name
     */
    public DimensionedEntityType(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

}
