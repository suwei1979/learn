/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.ddd.specification;

import lombok.Data;

@Data
public class Drum {
    private double size;
    private ContainerSpecification containerSpecification;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public ContainerSpecification getContainerSpecification() {
        return containerSpecification;
    }

    public void setContainerSpecification(ContainerSpecification containerSpecification) {
        this.containerSpecification = containerSpecification;
    }
}
