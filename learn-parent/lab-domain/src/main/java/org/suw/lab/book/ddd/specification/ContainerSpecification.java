/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.book.ddd.specification;

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
