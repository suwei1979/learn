/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.ddd.sideeffect;

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
