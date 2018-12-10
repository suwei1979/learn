/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Chapter 2.3
 *
 * @author suwei
 */
public class WildcardsWithExtends {

    public static void main(String... args) {
        // Example 1:
        List<Number> nums = new ArrayList<Number>();
        List<Integer> ints = Arrays.asList(1, 2);
        List<Double> dbls = Arrays.asList(2.78, 3.14);
        nums.addAll(ints);
        nums.addAll(dbls);
        assert nums.toString().equals("[1, 2, 2.78, 3.14]");

        // Example 2
        List<Integer> ints2 = Arrays.asList(1, 2);
        List<? extends Number> nums2 = ints2;
        /**
         * 下面语句放开后仍会报编译错误，也是就说，即便使用了extends方法，一旦被Assign了具体类型（Integer)
         * 还是不能再将非子类的对象指定给nums2
         */
        // nums2.add(3.14); // compile-time error
        assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!

        // Example 3
        List<SubType> subs = new ArrayList<SubType>();
        List<SubType1> sub1s = new ArrayList<WildcardsWithExtends.SubType1>();
        List<? extends ParentType> parents = new ArrayList<SubType>();
        SubType subType = new SubType() {
        };
        SubType1 subType1 = new SubType1() {
        };
        SubTypeOfSubType subOfSub = new SubTypeOfSubType() {
        };
        //		parents.add(subType);
        //		parents.add(subOfSub);
        //		parents.add(subType1);
        //
        //		parents = subs;
        //		parents.addAll(sub1s);

        subs.add(subType);
        subs.add(subOfSub);

    }

    private interface ParentType {

    }

    private interface SubType extends ParentType {

    }

    private interface SubType1 extends ParentType {

    }

    private interface SubTypeOfSubType extends SubType {

    }
}
