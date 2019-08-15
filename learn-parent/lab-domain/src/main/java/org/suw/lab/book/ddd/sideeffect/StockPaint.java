/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.book.ddd.sideeffect;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StockPaint extends Paint {

    public StockPaint(double volume, PigmentColor color) {
        this.volume = volume;
        this.color = color;
    }

}
