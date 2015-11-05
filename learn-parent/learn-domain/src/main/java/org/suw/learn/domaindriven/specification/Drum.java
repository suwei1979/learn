package org.suw.learn.domaindriven.specification;

import lombok.Data;

@Data
public class Drum {
	private double size;
	private ContainerSpecification containerSpecification;
}
