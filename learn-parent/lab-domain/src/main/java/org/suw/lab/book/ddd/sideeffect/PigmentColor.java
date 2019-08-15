/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.book.ddd.sideeffect;

import lombok.Data;

@Data
public class PigmentColor {
    private int red, yellow, blue;

    public PigmentColor(int red, int yellow, int blue) {
        this.red = red;
        this.yellow = yellow;
        this.blue = blue;
    }

    public PigmentColor mixedWith(PigmentColor pigmentColor, double radio) {
        // Many lines of complicated color-mixing logic
        // ending with the creation of a new PigmentColor object
        // with appropriate new red, blue, and yellow values.
        return null;
    }
}
