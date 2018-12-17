/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.container.queue;

import java.util.LinkedList;
import java.util.Queue;

public class DemoOfQueue {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("xiaoyun");
        queue.offer("yulong");
        queue.offer("羽龙共舞");
        String element = null;
        while ((element = queue.poll()) != null) {
            System.out.println(element + "\t");

        }
    }
}
