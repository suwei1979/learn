/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.ddd.specification;

import java.util.Collection;

public class PrototypePacker implements WarehousePacker {

    @Override
    public void pack(Collection<Container> containers, Collection<Drum> drumsToPack) throws NoAnswerFoundException {
        for (Drum aDrum : drumsToPack) {
            Container container = findContainerFor(containers, aDrum);
            container.add(aDrum);
        }

    }

    private Container findContainerFor(Collection<Container> containers, Drum aDrum) throws NoAnswerFoundException {
        for (Container container : containers) {
            if (container.canAccommodate(aDrum)) {
                return container;
            }
        }
        throw new NoAnswerFoundException();
    }

}
