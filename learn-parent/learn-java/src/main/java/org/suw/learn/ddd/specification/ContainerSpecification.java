/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.ddd.specification;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class ContainerSpecification {
    @Setter(AccessLevel.NONE)
    private ContainerFeature requiredFeature;

    public ContainerSpecification(ContainerFeature requiredFeature) {
        super();
        this.requiredFeature = requiredFeature;
    }

    public boolean isSatisfiedBy(Container container) {
        return container.getFeatures().contains(requiredFeature);
    }

}
