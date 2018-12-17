/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.ddd.specification;

import java.util.Collection;

public interface WarehousePacker {
    public void pack(Collection<Container> containers, Collection<Drum> drumsToPack) throws NoAnswerFoundException;
}
