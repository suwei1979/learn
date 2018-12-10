/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.java.exception;

public class ExceptionTest {
    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
            return;

        } finally {
            System.out.println("Hello world");
        }
    }
}

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}
