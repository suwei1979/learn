/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package test.spring.sample;

public class Boy {
    private Girl girl = null;
    private String name = null;

    public Boy(String name) {
        this.name = name;
    }

    public void seek() {
        girl = new Girl("Hotgirl");
        girl = GirlFactory.giveMeAGirl();
        // do something to make girl happy
    }

    public void kiss() {
        if (girl.permit()) {
            System.out.println("I just kissed my dream lover.Wow...");
        }
    }

    public void marry() {
        if (girl.permit()) {
            System.out.println("So happy.");
        }
    }

    public void setgirl(Girl aGirl) {
        this.girl = aGirl;
    }
}
