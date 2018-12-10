/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.domaindriven.sideeffect;

import lombok.Data;

@Data
public class Paint {
	protected double volume;
	protected PigmentColor color;

//	public Paint(double volume, PigmentColor pigmentColor) {
//		super();
//		this.volume = volume;
//		this.pigmentColor = pigmentColor;
//	}

	public void mixIn(Paint otherPaint) {
		volume += otherPaint.getVolume();
		double radio = otherPaint.getVolume() / volume;
		color = color.mixedWith(otherPaint.getColor(), radio);
	}

}
