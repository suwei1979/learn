/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.java.container.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoOfArrayList {
    public static void main(String[] args) {
        List<String> userList = new ArrayList<String>();
        userList.add("yulon");
        userList.add("xiaoyun");
        userList.add("羽龙共舞");

        System.out.println("use normal for loop");
        for (int i = 0; i < userList.size(); i++) {
            System.out.print(userList.get(i) + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("use iterator: ");
        Iterator it = userList.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("use enhanced for loop");
        for (String s : userList) {
            System.out.printf(s + " ");
        }

        System.out.println();

    }
}

