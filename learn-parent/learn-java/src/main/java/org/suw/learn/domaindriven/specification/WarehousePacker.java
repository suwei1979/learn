/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.domaindriven.specification;

import java.util.Collection;

public interface WarehousePacker {
	public void pack(Collection<Container> containers, Collection<Drum> drumsToPack) throws NoAnswerFoundException;
}
