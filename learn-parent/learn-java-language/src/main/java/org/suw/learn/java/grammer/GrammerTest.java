/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.grammer;

public abstract class GrammerTest {

    public static void main(String[] args) {
        System.out.println("2 << 3 = " + (2 << 3));

    }

    public abstract void templateMethod();
    // wrong combination
    //public abstract static void templateMethod1();
    //public abstract native void templateMethod2();
    //public abstract synchronized void templateMethod3();
}

class Outer {
    private static int outerStaticProperty;
    private int outerProperty;

    public static void main(String[] args) {
        //        new Inner();
    }

    //    public static void foo() { new Inner(); }

    public void bar() {
        new Inner();
    }

    class Inner {
        private int innerRefOuter;

        public Inner() {
            innerRefOuter = outerProperty;
            outerProperty = 4;
            outerStaticProperty = 3;
        }
    }
}