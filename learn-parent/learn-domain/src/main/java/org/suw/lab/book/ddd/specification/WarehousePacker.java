/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.book.ddd.specification;

import java.util.Collection;

public interface WarehousePacker {
    public void pack(Collection<Container> containers, Collection<Drum> drumsToPack) throws NoAnswerFoundException;
}
