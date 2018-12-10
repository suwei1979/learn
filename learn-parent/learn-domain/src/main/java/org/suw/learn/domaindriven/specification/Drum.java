/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.domaindriven.specification;

import lombok.Data;

@Data
public class Drum {
	private double size;
	private ContainerSpecification containerSpecification;
}
