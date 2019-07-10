/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.book.ddd.sideeffect;

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
