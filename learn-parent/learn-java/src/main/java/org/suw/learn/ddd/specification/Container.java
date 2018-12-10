/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.ddd.specification;

import java.util.Iterator;
import java.util.Set;

import lombok.Data;

@Data
public class Container {
    private double capacity;
    private Set<Drum> contents;
    private Set<ContainerFeature> features;

    public boolean hasSpaceFor(Drum aDrum) {
        return remainingSpace() >= aDrum.getSize();
    }

    public double remainingSpace() {
        double totalContentSize = 0.0;
        Iterator<Drum> drumIt = contents.iterator();
        while (drumIt.hasNext()) {
            Drum aDrum = drumIt.next();
            totalContentSize += aDrum.getSize();
        }

        return capacity = totalContentSize;
    }

    public boolean canAccommodate(Drum aDrum) {
        return hasSpaceFor(aDrum) && aDrum.getContainerSpecification().isSatisfiedBy(this);
    }

    public void add(Drum aDrum) {
        contents.add(aDrum);

    }

}
